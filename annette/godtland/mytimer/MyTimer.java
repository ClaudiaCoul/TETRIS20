package annette.godtland.mytimer;

import javax.swing.JFrame;

public class MyTimer extends JFrame {
  private static final long serialVersionUID = 1L;
  
  private TimerPanel timerPanel = new TimerPanel();
  
  public static void main(String[] args) {
    try {
      String className = UIManager.getCrossPlatformLookAndFeelClassName();
      UIManager.setLookAndFeel(className);
    }
    catch (Exception e) {}
    
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MyTimer();
      }
    });
  }
  
  public MyTimer() {
    initGUI();
    
    setTitle("My Timer");
    setResizable(false);
    pack();
    setLocationRelativeTo(null);
    setVisable(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
  public void initGUI() {
    TitleLabel titleLabel = new TitleLabel("My Timer");
    add.(titleLabel, BorderLayout, PAGE_START);
    
    JPanel centerPanel = new JPanel();
    add(centerPanel, BorderLayout.CENTER);
    
    centerPanel.add(timerPanel);
  }
}
