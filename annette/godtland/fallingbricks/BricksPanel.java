package annette.godtland.fallingbricks;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.Random;
public class BricksPanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private static final int ROWS = 15;
  private static final int COLS = 10;
  private static final int WIDTH = COLS * Brick.TILE_SIZE;
  private static final int HEIGHT = ROWS * Brick.TILE_SIZE;
  private static final int SHAPE_I = 0;
  private static final int SHAPE_J = 1;
  private static final int SHAPE_L = 2;
  private static final int SHAPE_O = 3;
  private static final int SHAPE_S = 4;
  private static final int SHAPE_T = 5;
  private static final int SHAPE_Z = 6;
  private static final int NUMBER_OF_SHAPES = 7;	
  private static final String SNAP_SOUND = "/snap.wav";
  private static final Brick brick;
  private Random rand = new Random();
  private BufferedImage[][] board;
  Tetris20 tetris20;
   Timer timer;
  
  public BricksPanel(Tetris20 tetris20){
  	this.tetris20 = tetris20;
    	initGUI();
        start();
  }
  
  public void start() {
    board = new BufferedImage[ROWS][COLS];
    pickABrick();
	  timer.start();
  }
  
  private void pickABrick() {
    int row = 0;
    int col = (COLS / 2);
    int pick = rand.nextInt(NUMBER_OF_SHAPES);
	    switch(pick){
		    case 1 : brick = new IBrick(row, col);
			     break;
		    case 2 : brick = new JBrick(row, col);
			     break;
		    case 3 : brick = new LBrick(row, col);
			     break;
		    case 4 : brick = new OBrick(row, col);
			     break;
		    case 5 : brick = new SBrick(row, col);
			     break;
		    case 6 : brick = new TBrick(row, col);
			     break;
		    case 7 : brick = new ZBrick(row, col);
			     break;
	    }
	    if(!isLegal()){
		brick = null;
		timer.stop();
		String message = "Wow U suck... Try harder";
		int option = JOptionPane.showConfirmDialog(this, message, "Play Again?", JOptionPane.YES_NO_OPTION);
		if(option == JOptionPane.YES_OPTION){
			tetris20.restart();
		}else{
			System.exit(0);
		}
	    }
  }
  
  public Dimension getPreferredSize(){
    Dimension size = new Dimension(WIDTH, HEIGHT);
    return size;
  }
  
   private void removeFilledRows() {
	 int count = 0;
   	 for (int row = ROWS; row >= 0; row--) { 
      		boolean filled = true;
      		while (filled) {
         		for (int col = 0; col <= COLS; col++) {
            			if(board[row][col] == null) {
                			filled = false;
            			}
        		 }
         		 if (filled) {
            		 	for (int r = row; r <= ROWS; r++) {
               		 		for (int c = 0; c <= COLS; c++) {
                  				board[r][c] = board[r-1][c];
               				}
            		 	 }
            		 	 row++;
				 count++;
         		}
     		}
 	 }
	 calculateScore(count);
   }
  private void calculateScore(int count){
	  switch(count){
		  case 1: tetris20.addToScore(1);
			  break;
		  case 2: tetris20.addToScore(2);
			  break;
		  case 3: tetris20.addToScore(3);
			  break;
		  case 4: tetris20.addToScore(4);
			  break;
	  }
  }
	
	   
  public void paintComponent(Graphics g) {
    //Background
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, WIDTH, HEIGHT);
    
    // fallen bricks
    
    // falling bricks
    if (brick != null) {
      brick.draw(g); //might not work!
    }
  }
   private void initGUI(){
    setFocusable(true);
    addKeyListener(new KeyAdapter(){
	       public void KeyPressed(KeyEvent e){
		   int code = e.getKeyCode();
			   switch(code) {
		           	case KeyEvent.VK_LEFT:
			      		moveLeft();
		              		break;
			      	case KeyEvent.VK_RIGHT:
			      		moveRight();
			      		break;
			      	case KeyEvent.VK_Z:
			      		rotateLeft();
			        	break;
			        case KeyEvent.VK_X:
			        	rotateRight();
			      		break;
		         	case KeyEvent.VK_SPACE:
		           		drop();
		           		break;     
			   }
	       }
      }); //weird shit just leave it alone
	   timer = new Timer(40, new ActionListener() {
		   public void actionPerformed(ActionEvent e){
			   timedAction();
		   }
	   }); //more wild code... dont mess w it
}
  
  private void moveLeft(){  
  	brick.moveLeft();
	if(isLegal()){
		repaint();
	}
	  else{
		  brick.moveRight();
	  }
  }

  private void moveRight(){
	  brick.moveRight();
	  if(isLegal()){
		repaint();
	}
	  else{
		  brick.moveLeft();
	  }
  }
  
  private void rotateLeft() {
     brick.rotateLeft();
     if (isLegal()) {
        repaint();
     }
     else {
       brick.rotateRight();
     }
  }
	
  private void rotateRight() {
     brick.rotateRight();
     if (isLegal()) {
	repaint();
     }
     else {
       brick.rotateLeft();
     }
  }
  private void drop() {
   //drop the brick to its lowest position
   boolean legal = true;
   while (legal) {
      brick.drop1Row();
      if (!isLegal()) {
        legal = false;
	brick.rise1Row();
      }
     }
     insertBrick();
     repaint();
  }
	//check if required space is empty
  private boolean isLegal(){
    boolean legal = true;
    int row = brick.getRow();
    int col = brick.getColumn();
    int brickRows = brick.getNumberOfRows();
    int brickColumns = brick.getNumberOfColumns();
    
    //check if beyond left or right edge of panel
    if(col < 0 || brickColumns + col > COLS){
      legal = false;
    }
    //checks if in top or bottom edge of panel
    else if(row < 0 || row + brickRows > ROWS){
      legal = false;
    }
	else{
		for(int r = 0; r < brickRows; r++){
			for(int c = 0; c < brickColumns; c++){
				if(brick.hasTileAt(r, c) && board[row + r][col + c] != null){
					legal = false;
				}
			}
		}
	}
  
    return legal;
  }
  private void insertBrick(){
	   int brickRow = brick.getRow();
	   int brickCol = brick.getColumn();
	   int brickRows = brick.getNumberOfRows();
	   int brickCols = brick.getNumberOfColumns();
	   int row;
	   int col;
	   for(int r = 0; r < brickRows; r++){
	      for(int c = 0; c < brickCols; c++){
		 if(brick.hasTileAt(r, c)){
		    row += r + brickRow;
		    col += c + brickCol;
		    board[row][col] = brick.getTileImage();
		  } 
	       }
	    } 
	   FileIO.playClip(this, SNAP_SOUND);
	   removeFilledRows();
	   pickABrick();
 }
 
 private void timedAction(){
	 brick.fall(2);
	 
	 //if cant fall further, set into place!
	 if(!isLegal()){
		 brick.fall(-2);
		 drop();
	 }
	 else{
		 repaint();
	 }
 }
		 
	
	 
	 
}
