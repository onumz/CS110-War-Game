import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test extends JFrame
{
   private War war;
   private JLabel userDeck;
   
   public Test()
   {
      war = new War();
      String temp = war.userSizeToString();
      userDeck = new JLabel(temp);
   }
}