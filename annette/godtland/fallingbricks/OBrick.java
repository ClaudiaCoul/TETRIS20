package annette.godtland.fallingbricks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class OBrick extends Brick{  
  private static final String BRICK_FILE = "/yellowBrick.jpg";
  private static final boolean[][] TILES = {{true, true},
                                            {true, true}};
  private static BufferedImage image;

  public OBrick(int row, int col) {
    super(row, col);
    if (image == null) {
      image = FileIO.readImageFile(this, BRICK_FILE);
    }
  }
  
  public void rotateLeft() {
    
  }
  
  public void rotateRight() {
    
  }
  
  public void draw(Graphics g) {
    int rows = TILES.length;
    int cols = TILES[0].length;
    
    for (int row = 0; row <= rows; row++) {
      for (int col = 0; col <= cols; col++) {
        if (TILES[row][col] == true) {
          int tileX = x + (TILE_SIZE * col);
          int tileY = y + (TILE_SIZE * row);
          g.drawImage(image, tileX, tileY, null);
        }
      }//end col forloop
    }//end row forloop
  }//end draw method
  
  public boolean hasTileAt(int row, int col){
    return TILES[row][col];
  }
  
  public int getNumberOfRows(){
    return TILES.length;
  }
  
  public int getNumberOfColumns(){
    return TILES[0].length;
  }
  
  public BufferedImage getTileImage(){
    return image;
  }
}
