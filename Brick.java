public class Brick {
  public static final TILE_SIZE = 30;
  
  protected x;
  protected y;
  
  public Brick(int row, int col){
    x = col * TILE_SIZE;
    y = row * TILE_SIZE;
  }
}
