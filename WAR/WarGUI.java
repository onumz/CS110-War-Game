import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War warGame;
   private JPanel uDeckPanel, uDrawPanel, uWarPanel, 
            flipPanel, warPanel, cWarPanel, cDrawPanel, cDeckPanel;
   private JLabel userDeck, compDeck, userDraw, compDraw, userWar, compWar;
   private ImageIcon back;
   private Button flip, war;
   private final int WAR_CARD = 1;
   
   public WarGUI()
   {
      warGame = new War();
      
      setTitle("Welcome to the Game of War");
      
      setLayout(new FlowLayout());
      
      back = new ImageIcon("back.jpg");
      
      userDeck = new JLabel(warGame.userSizeToString());
      userDeck.setIcon(back);
      uDeckPanel = new JPanel();
      uDeckPanel.add(userDeck);
      add(uDeckPanel);
      
      userDraw = new JLabel();
      userDraw.setIcon(back);
      uDrawPanel = new JPanel();
      uDrawPanel.add(userDraw);
      add(uDrawPanel);
      uDrawPanel.setVisible(false);
      
      userWar = new JLabel();
      userWar.setIcon(back);
      uWarPanel = new JPanel();
      uWarPanel.add(userWar);
      add(uWarPanel);
      uWarPanel.setVisible(false);
      
      flip = new Button("FLIP");
      flip.addActionListener(new Flip());
      flipPanel = new JPanel();
      flipPanel.add(flip);
      add(flipPanel);
      
      war = new Button("WAR");
      war.addActionListener(new WarButton());
      war.setEnabled(false);
      warPanel = new JPanel();
      warPanel.add(war);
      add(warPanel);
      
      compWar = new JLabel();
      compWar.setIcon(back);
      cWarPanel = new JPanel();
      cWarPanel.add(compWar);
      add(cWarPanel);
      cWarPanel.setVisible(false);
      
      compDraw = new JLabel();
      compDraw.setIcon(back);
      cDrawPanel = new JPanel();
      cDrawPanel.add(compDraw);
      add(cDrawPanel);
      cDrawPanel.setVisible(false);
      
      compDeck = new JLabel(warGame.compSizeToString());
      compDeck.setIcon(back);
      cDeckPanel = new JPanel();
      cDeckPanel.add(compDeck);
      add(cDeckPanel);
   }
   private class Flip implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (warGame.userIsEmpty() == false && warGame.compIsEmpty() == false)
         {
            int r = warGame.compareCard(0);
            
            uDrawPanel.setVisible(true);
            cDrawPanel.setVisible(true);
            
            userDraw.setIcon(warGame.getCardPicUser(0));
            userWar.setIcon(back);
            compDraw.setIcon(warGame.getCardPicComp(0));
            compWar.setIcon(back);
            
            uDrawPanel.setVisible(true);
            cDrawPanel.setVisible(true);
            
            if (r == 0)
            {
               war.setEnabled(true);
               flip.setEnabled(false);
               userDeck.setText(warGame.userSizeToString());
               compDeck.setText(warGame.compSizeToString());
            }
            if (r == 1)
            {
               warGame.userWin();
            }
            if (r == 2)
            {
               warGame.compWin();
            }
            
            userDeck.setText(warGame.userSizeToString());
            compDeck.setText(warGame.compSizeToString());
            if (r == -99)
            {
               JOptionPane.showMessageDialog(null,"Something went wrong");
            }
         }
         else if (warGame.compIsEmpty()== true)
         {
            JOptionPane.showMessageDialog(null,"USER HAS WON");
         }
         else if (warGame.userIsEmpty()== true)
         {
            JOptionPane.showMessageDialog(null,"COMPUTER HAS WON");
         }
      }
   }
   private class WarButton implements ActionListener
   {
      public void actionPerformed(ActionEvent f)
      {
         if (warGame.userDeckSize()>= WAR_CARD || warGame.compDeckSize()>= WAR_CARD)
         {
            userDraw.setIcon(back);
            compDraw.setIcon(back);
            userWar.setIcon(warGame.getCardPicUser(1));
            compWar.setIcon(warGame.getCardPicComp(1));
            
            int index = 1;
            int warWin = warGame.compareCard(index);
            
            if (warWin == 1)
            {
               for(int z=0; z<=index;z++)
               {
                  warGame.userWin();
               }
               war.setEnabled(false);
               flip.setEnabled(true);
            }
            
            else if (warWin == 2)
            {
               for(int q=0; q<=index;q++)
               {
                  warGame.compWin();
               }
               war.setEnabled(false);
               flip.setEnabled(true);
            }
            
            else if (warWin == -99)
            {
               JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
            else if (warWin == 0)
            {
               war.setEnabled(true);
               index+=1;
            }
            
            userDeck.setText(warGame.userSizeToString());
            compDeck.setText(warGame.compSizeToString()); 
         }
         else if (warGame.userDeckSize()<= 1)
         {
            JOptionPane.showMessageDialog(null,"User has run out of cards. /n Computer Wins");
         }
            
         else if (warGame.compDeckSize()<= 1)
         {
            JOptionPane.showMessageDialog(null,"Computer has run out of cards. /n User Wins");
         }
            
         userDeck.setText(warGame.userSizeToString());
         compDeck.setText(warGame.compSizeToString());           
         
      }
   }
}