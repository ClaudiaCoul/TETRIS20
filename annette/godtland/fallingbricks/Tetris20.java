package annette.godtland.fallingbricks;



import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Tetris20 extends JFrame {
   private static final long serialVersionUID = 1L;
   private ScorePanel scorePanel = new ScorePanel(0, Color.CYAN);
   private BricksPanel bricksPanel = new BricksPanel(this);
   
   public static void main(String[] args){
      try{
         String className = UIManager.getCrossPlatformLookAndFeelClassName();
         UIManager.setLookAndFeel(className);
      }catch(Exception e){}
      
      SwingUtilities.invokeLater(new Runnable(){
         public void run(){
            new Tetris20();
         }
      });
     
   }
   public Tetris20(){
	  setFocusable(true);
	  setFocusTraversalKeysEnabled(false);
      initGUI();
      setTitle("Tetris20");
      setResizable(false);
      pack();
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
  public void initGUI(){
     JLabel titleLabel = new JLabel("Tetris20");
     add(titleLabel, BorderLayout.PAGE_START);
     //main panel
     JPanel mainPanel = new JPanel();
     mainPanel.setBackground(Color.CYAN);
     mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
     add(mainPanel, BorderLayout.CENTER);
         
     //score panel
     add(scorePanel, BorderLayout.NORTH);
     
     //bricks panel
     mainPanel.add(bricksPanel);
     addKeyListener(new KeyAdapter(){
	       public void keyPressed(KeyEvent e){
		   int code = e.getKeyCode();
	       }
    });
  }
   
   public void addToScore(int points){
      scorePanel.addToScore(points);
   }
   
   public void restart(){
      scorePanel.reset();
      bricksPanel.start();
   }
      
}
