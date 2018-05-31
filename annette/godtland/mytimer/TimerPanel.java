package annette.godtland.mytimer;

import javax.swing.JPanel;

public class TimerPanel extends JPanel {
  private static final long serialVersionUID = 1L;
  
  private int width = 150;
  private int height = 24;
  private String timeString = "00:00:00";
  private long time = 10;
  
  public TimerPanel(long time, Font font) {
    setTime(time);
    setFont(font);
    height = font.getSize();
    FontMetrics fm = getFontMetrics(font);
    width = fm.stringWidth(timeString);
  }
  
  public void paintComponent (Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.drawString(timeString, 0, height);
  }
  
  public Dimension getPreferredSize() {
    Dimension size = new Dimension(width, height);
    return size;
  }
  
  public void setTime(long time) {
    this.time = time;
    long h = time / 3600;
    long m = (time / 60) % 60;
    long s = time % 60;
    timeString = String.format("%02d:%02d:%02d", h, m, s);
    repaint();
}
