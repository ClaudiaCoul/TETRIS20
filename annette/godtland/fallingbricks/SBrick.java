//LOG
//Created by Amanda, 05/18/18

package annette.godtland.fallingbricks;
import java.awt.image.BufferedImage;


public class SBrick extends Brick {
  
  private static final string BRICK_FILE "/redBrick.jpg";
  private static final boolean[][] TILES = {{false, false, false},
                                            {false, false, false}};
  private static BufferedImage image;

  public SBrick(int row, int col) {
    super(row, col);
    if (image == null) {
      image = FileIO.readImageFile(this);
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
}
