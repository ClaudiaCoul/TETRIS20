package annette.godtland.mytimer;

import javax.swing.JPanel;

public class TimerPanel extends JPanel {
  private static final long serialVersionUID = 1L;
  
  private int width = 150;
  private int height = 24;
  private String timeString = "00:00:00";
  
  public void paintComponent (Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.drawString(timeString, 0, height);
  }
  
  public Dimension getPreferredSize() {
    Dimension size = new Dimension(width, height);
    return size;
  }
}
