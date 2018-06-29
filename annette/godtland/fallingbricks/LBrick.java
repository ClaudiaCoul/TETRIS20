package annette.godtland.fallingbricks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class LBrick extends Brick{
  
  private static final String BRICK_FILE = "greenBrick.jpg";
  private static final boolean[][][] TILES = {{{true, true, true},
                                               {true, false, false}},
                                              
                                              {{true, true},
                                               {false, true},
                                               {false, true}},
                                              
                                              {{false, false, true},
                                               {true, true, true}},
                                              
                                              {{true, false},
                                               {true, false},
                                               {true, true}}};
  private static BufferedImage image = null;
  private int state = 0;

  public LBrick(int row, int col) {
    super(row, col);
    if (image == null) {
      image = FileIO.readImageFile(this, BRICK_FILE);
    }
  }
  
  public void rotateLeft() {
    state--;
    if (state < 0) {
      state = TILES.length - 1;
    }
  }
  
  public void rotateRight() {
    state++;
    if (state >= TILES.length) {
      state = 0;
    }
  }
  
  public void draw(Graphics g) {
    int rows = TILES[state].length;
    int cols = TILES[state][0].length;
    
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (TILES[state][row][col] == true) {
          int tileX = x + (TILE_SIZE * col);
          int tileY = y + (TILE_SIZE * row);
          g.drawImage(image, tileX, tileY, null);
        }
      }//end col forloop
    }//end row forloop
  }//end draw method
  
  public boolean hasTileAt(int row, int col){
    return TILES[state][row][col];
  }
  
  public BufferedImage getTileImage(){
    return image;
  }
  
  public int getNumberOfRows(){
    return TILES[state].length;
  }
  
  public int getNumberOfColumns(){
    return TILES[state][0].length;
  }
  
}
