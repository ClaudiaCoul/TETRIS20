package annette.godtland.mytimer;

import javax.swing.JFrame;

public class MyTimer extends JFrame {
  private static final long serialVersionUID = 1L;
  
  private Font font = new Font(Font.DIALOG, Font.BOLD, 36);
  private TimerPanel timerPanel = new TimerPanel(0, font);
  
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
  private void start() {
    timerPanel.start();
  }
  
  private void stop() {
    timePanel.stop();
  }
  private void addAnHour() {
    long time = timerPanel.getTime();
    time += 3600;
    timerPanel.setTime(time);
  }
  
  private void addAMinute() {
    long time = timerPanel.getTime();
    time += 60;
    timerPanel.setTime(time);
  }
  private void clear() {
    timerPanel.stop();
    timerPanel.setTime(0);
  }
  
  public void initGUI() {
    TitleLabel titleLabel = new TitleLabel("My Timer");
    add.(titleLabel, BorderLayout, PAGE_START);
    
    JPanel centerPanel = new JPanel();
    centerPanel.setBackground(Color.MAGENTA);
    add(centerPanel, BorderLayout.CENTER);
    
    timerPanel.setBackground(Color.MAGENTA);
    centerPanel.add(timerPanel);
    
    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(Color.BLACK);
    add(buttonPanel, BorderLayout.PAGE_END);
    
    JButton hoursButton = new JButton("Hour");
    hoursButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addAnHour();
      }
    });
    buttonPanel.add(hoursButton);
    
    JButton minutesButton = new JButton("Min");
    minutesButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addAMinute();
      }
    });
    buttonPanel.add(minutesButton);
    
    JButton clearButton = new JButton("Clear");
    clearButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        clear();
      }
    });
    buttonPanel.add(clearButton);
    
    JButton startButton = new JButton("Start");
    startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        start();
      }
    });
    buttonPanel.add(startButton);
    
    JButton stopButton = new JButton("Stop");
    stopButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        stop();
      }
    });
    buttonPanel.add(stopButton);
  }
  
}
