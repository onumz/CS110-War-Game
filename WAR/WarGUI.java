/**
 * Class for the card game war  
 * Has everything necessary for it to be used in a GUI game of war 
 *
 * @author Olivia Numa
 */

//import stuff
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   //declare everything
   private War warGame;
   private JPanel uDeckPanel, uDrawPanel, uWarPanel, 
            flipPanel, warPanel, cWarPanel, cDrawPanel, cDeckPanel;
   private JLabel userDeck, compDeck, userDraw, compDraw, userWar, compWar;
   private ImageIcon back;
   private Button flip, war;
   
   /**
    * Constructor creates a war object and sets up the GUI  
    */
   public WarGUI()
   {
      //create war object
      warGame = new War();
      
      setTitle("Welcome to the Game of War");
      
      setLayout(new FlowLayout());
      
      back = new ImageIcon("back.jpg");
      
      //panel for the user's hand
      userDeck = new JLabel(warGame.userSizeToString());
      userDeck.setIcon(back);
      uDeckPanel = new JPanel();
      uDeckPanel.add(userDeck);
      add(uDeckPanel);
      //panel for the user's draw card
      userDraw = new JLabel();
      userDraw.setIcon(back);
      uDrawPanel = new JPanel();
      uDrawPanel.add(userDraw);
      add(uDrawPanel);
      uDrawPanel.setVisible(false);
      //panel for the user's war pile
      userWar = new JLabel();
      userWar.setIcon(back);
      uWarPanel = new JPanel();
      uWarPanel.add(userWar);
      add(uWarPanel);
      uWarPanel.setVisible(false);
      //panel for flip button
      flip = new Button("FLIP");
      flip.addActionListener(new Flip());
      flipPanel = new JPanel();
      flipPanel.add(flip);
      add(flipPanel);
      //panel for war button
      war = new Button("WAR");
      war.addActionListener(new WarButton());
      war.setVisible(false);
      warPanel = new JPanel();
      warPanel.add(war);
      add(warPanel);
      //panel for computer's war pile
      compWar = new JLabel();
      compWar.setIcon(back);
      cWarPanel = new JPanel();
      cWarPanel.add(compWar);
      add(cWarPanel);
      cWarPanel.setVisible(false);
      //panel for computer's draw card
      compDraw = new JLabel();
      compDraw.setIcon(back);
      cDrawPanel = new JPanel();
      cDrawPanel.add(compDraw);
      add(cDrawPanel);
      cDrawPanel.setVisible(false);
      //panel for computer's hand
      compDeck = new JLabel(warGame.compSizeToString());
      compDeck.setIcon(back);
      cDeckPanel = new JPanel();
      cDeckPanel.add(compDeck);
      add(cDeckPanel);
   }
   
   //acts when the user draws and the cards are not equal
   private class Flip implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {  
         //only work if either deck is empty
         if (warGame.userIsEmpty() == false || warGame.compIsEmpty() == false)
         {
            //result from comparing cards
            int r = warGame.compareCard(0);
            
            uWarPanel.setVisible(false);
            cWarPanel.setVisible(false);
            uDrawPanel.setVisible(true);
            cDrawPanel.setVisible(true);
            
            //show "flipped" cards
            userDraw.setIcon(warGame.getCardPicUser(0));
            userWar.setIcon(back);
            compDraw.setIcon(warGame.getCardPicComp(0));
            compWar.setIcon(back);
            
            //if equal, go to war
            if (r == 0)
            {
               war.setVisible(true);
               flip.setVisible(false);
               userDeck.setText(warGame.userSizeToString());
               compDeck.setText(warGame.compSizeToString());
            }
            //user win
            if (r == 1)
            {
               warGame.userWin();
            }
            //computer win
            if (r == 2)
            {
               warGame.compWin();
            }
            //update display
            userDeck.setText(warGame.userSizeToString());
            compDeck.setText(warGame.compSizeToString());
            
            //if something goes wrong
            if (r == -99)
            {
               flip.setVisible(false);
               JOptionPane.showMessageDialog(null,"Something went wrong");
            }
         }
         //if computer's hand is empty
         if (warGame.compIsEmpty() == true)
         {
            flip.setVisible(false);
            JOptionPane.showMessageDialog(null,"USER HAS WON");
         }
         //if user's hand is empty
         else if (warGame.userIsEmpty() == true)
         {
            flip.setVisible(false);
            JOptionPane.showMessageDialog(null,"COMPUTER HAS WON");

         }
      }
   }
   //acts when the user draws and the cards are equal
   private class WarButton implements ActionListener
   {
      public void actionPerformed(ActionEvent f)
      {
         int index = 2;
         //if user has enough cards for war
         if (warGame.userDeckSize()>= index || warGame.compDeckSize()>= index)
         {
            
            uWarPanel.setVisible(true);
            cWarPanel.setVisible(true);
            userDraw.setIcon(back);
            compDraw.setIcon(back);
            
            //get correct image
            userWar.setIcon(warGame.getCardPicUser(index));
            compWar.setIcon(warGame.getCardPicComp(index));
            
            int warWin = warGame.compareCard(index);
            
            //if user won
            if (warWin == 1)
            {
               for(int z=0; z<=index;z++)
               {
                  warGame.userWin();
               }
               war.setVisible(false);
               flip.setVisible(true);
            }
            
            //if computer won
            else if (warWin == 2)
            {
               for(int q=0; q<=index;q++)
               {
                  warGame.compWin();
               }
               war.setVisible(false);
               flip.setVisible(true);
            }
            //if something went wrong
            else if (warWin == -99)
            {
               war.setVisible(false);
               JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            //if cards are equal
            else if (warWin == 0)
            {
               war.setVisible(true);
               index+=1;
            }
            //update deck sizes
            userDeck.setText(warGame.userSizeToString());
            compDeck.setText(warGame.compSizeToString()); 
         }
         //if user runs out of cards
         else if (warGame.userDeckSize()<=index)
         {
            war.setVisible(false);
            JOptionPane.showMessageDialog(null,"User has run out of cards. \n Computer Wins");
            
         }
         //if computer runs out of cards   
         else if (warGame.compDeckSize()<=index)
         {
            war.setVisible(false);
            JOptionPane.showMessageDialog(null,"Computer has run out of cards. \n User Wins");
            
         }
         //update deck sizes   
         userDeck.setText(warGame.userSizeToString());
         compDeck.setText(warGame.compSizeToString());           
         
      }
   }
}