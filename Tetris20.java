package annette.godtland.fallingbricks;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
public class Tetris20 extends JFrame {
   private static final long serialVersionUID = 1L;
   public static void main(String[] args){
      try{
         String className = UIManager.getCrossPlatformLookAndFeelClassName();
         UIManager.setLookAndFeel(className);
      }catch(Exception e){}
      
      SwingUtilities.invokeLater(Runnable doRun){
         public void run(){
            new Tetris20;
         }
      }
     
   }
   public Tetris20(){
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
     add(PAGE_START);
     //main panel
     
     //score panel
     
     //bricks panel
  }
}