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
  
  public BricksPanel(){
    initGUI();
    start();
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
  }
  private void initGUI(){
   
   }
  
  private boolean isLegal(){
    boolean legal = true;
    int row = brick.getRow();
    int col = brick.getColumn();
    int brickRows = brick.getNumberofRows();
    int brickColumns = brick.getNumberOfColumns();
    return legal;
  }
}
