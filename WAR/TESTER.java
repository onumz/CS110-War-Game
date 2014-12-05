import javax.swing.*;

public class TESTER
{
   public static void main(String[]args)
   {
      JFrame frame = new WarGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.setSize(1500,300);
      frame.validate();
      frame.setVisible(true);
      
     
   }
}