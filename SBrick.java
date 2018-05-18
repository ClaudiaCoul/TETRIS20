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
}
