package annette.godtland.fallingBricks;
import javax.swing.JPanel;
public class ScorePanel extends JPanel {
  private static final long serialVersionUID = 1L;
  private int initialScore = 0;
  private int score = 0;
  
  public ScorePanel(int initialScore, Color color){
    this.initialScore = initialScore;
    score = initialScore;
    setBackground(color);
  }
  
  
