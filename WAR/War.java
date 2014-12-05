/**
 * Class for the card game war  
 * Has everything necessary for it to be used in a GUI game of war 
 *
 * @author Olivia Numa
 */

import java.util.ArrayList;
import javax.swing.*;

public class War
{
   /** 
   *  ArrayList representing the user's hand
   **/
   public ArrayList<Card> userDeck;
   /** 
   *  ArrayList representing the computer's hand
   **/
   public ArrayList<Card> compDeck;
   /** 
   *  Full deck
   **/
   public Deck1 deck;
   
   //Full size of deck
   public final int CARDS_IN_DECK = 52;
   //Half of the deck: 52/2 = 26
   public final int HALF_DECK = 26;
   //So there's no magic numbers 
   public final int ZERO = 0;
   
   /**
    * Constructor creates a deck and then splits it
    * into two 26-card arraylists, userHand and compHand
    *   
    */
   public War()
   {
      deck = new Deck1();
      deck.shuffle();
      
      userDeck = new ArrayList<Card>(HALF_DECK);
      compDeck = new ArrayList<Card>(HALF_DECK);
      
      for(int i = ZERO; i<HALF_DECK; i++)
      {
         userDeck.add(deck.dealCard());
      }
      
      for(int j = HALF_DECK; j<CARDS_IN_DECK; j++)
      {
         compDeck.add(deck.dealCard());
      }
   }
   
   /**
    * compareCard method compares two cards 
    * and returns 0 if they are equal, 1 if the user's is greater,
    * and 2 if the computer's is greater.
    * -99 is simply in case something goes wrong
    *
    */
   public int compareCard(int i)
   {
      int r;
      
      if (userDeck.get(i).getRank()==compDeck.get(i).getRank())
      {
         r = 0;
      }
      else if (userDeck.get(i).getRank()>compDeck.get(i).getRank())
      {
         r = 1;
      }
      else if (userDeck.get(i).getRank()<compDeck.get(i).getRank())
      {
         r = 2;
      }
      else
      {
         r = -99;
      }
      
      return r;
   }
   
   public void userWin()
   {
      userDeck.add(compDeck.get(0));
      userDeck.add(userDeck.get(0));
      
      userDeck.remove(userDeck.get(0));
      compDeck.remove(compDeck.get(0));
   }
   
   public void compWin()
   {
      compDeck.add(userDeck.get(0));
      compDeck.add(compDeck.get(0));
      
      compDeck.remove(compDeck.get(0));
      userDeck.remove(userDeck.get(0));
   }
   
   public ImageIcon getCardPicUser(int i)
   {
      String s = userDeck.get(i).cardPic();
      ImageIcon image = new ImageIcon(s);
      return image;
   }
   
   public ImageIcon getCardPicComp(int i)
   {
      String s = compDeck.get(i).cardPic();
      ImageIcon image = new ImageIcon(s);
      return image;
   }
   
   public boolean userIsEmpty()
   {
      boolean empty = false;
      if(userDeck.isEmpty() == true)
      {
         empty = true;
      }
      return true;
   }
   
   public boolean compIsEmpty()
   {
      boolean empty = false;
      if(compDeck.isEmpty() == true)
      {
         empty = true;
      }
      return true;
   }
   
   public int userDeckSize()
   {
      return userDeck.size();
   }
   
   public int compDeckSize()
   {
      return compDeck.size();
   }
   
   public String userSizeToString()
   {
      String s = Integer.toString(userDeck.size());
      return s;
   }
   
   public String compSizeToString()
   {
      String s = Integer.toString(compDeck.size());
      return s;
   }
}