//Austin
package annette.godtland.fallingbricks;

import javax.swing.JPanel;
import java.awt.*;

public class BricksPanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private static final int ROWS = 15;
  private static final int COLS = 10;
  private static final int WIDTH = COLS * TILE_SIZE;
  private static final int HEIGHT = ROWS * TILE_SIZE;
  private static final SBrick brick;
  
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
    brick = new SBrick(row, col);
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
