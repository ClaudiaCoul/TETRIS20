package annette.godtland.mytimer;

import javax.swing.JPanel;

public class TimerPanel extends JPanel implements Runnable {
  private static final long serialVersionUID = 1L;
  
  private int width = 150;
  private int height = 24;
  private String timeString = "00:00:00";
  private long time = 10;
  private Thread timerThread;
  
  public TimerPanel(long time, Font font) {
    setTime(time);
    setFont(font);
    height = font.getSize();
    FontMetrics fm = getFontMetrics(font);
    width = fm.stringWidth(timeString);
    start();
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
  public void start() {
    stop();
    timerThread = new Thread(this);
    timerThread.start();
  }
  public void stop() {
    if (timerThread != null) {
      timerThread.interrupt();
      timerThread = null;
  }
  
  public void run() {
    while (time > 0) {
      time -= 1;
      setTime(time);
      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException e) {
        return;
      }
    }
    timesUp();
  }
  public long getTime() {
    return time;
  }
    
  protected void timesUp() {
    String message = "Time's Up!";
    JOptionPane.showMessageDialog(this, message);
  }
}
