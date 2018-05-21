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
  
  public int getColumn(){
    int col = x/TILE_SIZE;
    return col;
  }
  
  public int getRow(){
    int row = (y + TILE_SIZE - 1) / TILE_SIZE;
  }
  
  public int getNumberOfRows(){
    return TILES.length();
  }
  
  public int getNumberOfColumns(){
    return TILES[0].length();
  }
}
  
