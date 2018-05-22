//Austin
package annette.godtland.fallingbricks;

import javax.swing.JPanel;
import java.awt.*;

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
	private static final int SHAPE_NUMBER_OF_SHAPES = 7;
  private static final Brick brick;
  Random rand = new Random();
	
	
  
  public BricksPanel(){
    initGUI();
    start();
  }
  
  public void start() {
    pickABrick();
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
  
  public Dimension getPreferredSize(){
    Dimension size = new Dimension(WIDTH, HEIGHT);
    return size;
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
    setFocusable();
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
	   }
	}
     });
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
	
  private boolean isLegal(){
    boolean legal = true;
    int row = brick.getRow();
    int col = brick.getColumn();
    int brickRows = brick.getNumberofRows();
    int brickColumns = brick.getNumberOfColumns();
    
    //check if beyond left or right edge of panel
    if(col < 0 || brickCols + col > COLS){
      legal = false;
    }
    //checks if in top or bottom edge of panel
    else if(row < 0 || row + brickRows > ROWS){
      legal = false;
    }
    return legal;
  }
}
