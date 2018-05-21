package annette.godtland.fallingbricks;

public class Brick {
  public static final int TILE_SIZE = 30;
  
  protected int x;
  protected int y;
  
  public Brick(int row, int col){
    x = col * TILE_SIZE;
    y = row * TILE_SIZE;
  }
  
  public void moveLeft(){
    x -= TILE_SIZE;
  }
  
  public void moveRight(){
    x += TILE_SIZE;
  }
}
