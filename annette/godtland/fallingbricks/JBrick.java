//whoop whoop amanda 


package annette.godtland.fallingbricks;
import java.awt.image.BufferedImage;


public class JBrick extends Brick {
 
 private static final string BRICK_FILE "/cyanBrick.jpg";
  private static final boolean[][][] TILES = {{{true, true, true},
                                               {false, false, true}},
                                              
                                              {{false, true},
                                               {false, true},
                                               {true, true}},
                                              
                                              {{true, false, false},
                                               {true, true, true}},
                                              
                                              {{true, true},
                                               {true, false},
                                               {true, false}}};
  private static BufferedImage image;

  public JBrick(int row, int col) {
    super(row, col);
    if (image == null) {
      image = FileIO.readImageFile(this, BRICK_FILE);
    }
  }
  
  public void rotateLeft() {
    state -= 1;
    if (state < 0) {
      state = TILES.length - 1;
    }
  }
  
  public void rotateRight() {
    state += 1;
    if (sate >= TILES.length) {
      state = 0;
    }
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
  
  public BufferedImage getTileImage(){
    return image;
  }
}
