/**
 * Class for the card game war  
 * Has everything necessary for it to be used in a GUI game of war 
 *
 * @author Olivia Numa
 */

//import stuff
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
      //create deck object & shuffle
      deck = new Deck1();
      deck.shuffle();
      
      //create arraylists representing user hand and computer hand
      userDeck = new ArrayList<Card>(HALF_DECK);
      compDeck = new ArrayList<Card>(HALF_DECK);
      
      //add cards to user's hand
      for(int i = ZERO; i<HALF_DECK; i++)
      {
         userDeck.add(deck.dealCard());
      }
      
      //add cards to computer's hand
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
    *@return int representing who won
    *@param i int index
    */
   public int compareCard(int i)
   {
      int r;
      //if they're equal
      if (userDeck.get(i).getRank()==compDeck.get(i).getRank())
      {
         r = 0;
      }
      //if user's is higher
      else if (userDeck.get(i).getRank()>compDeck.get(i).getRank())
      {
         r = 1;
      }
      //if computer's is higher
      else if (userDeck.get(i).getRank()<compDeck.get(i).getRank())
      {
         r = 2;
      }
      //in case something gets messed up
      else
      {
         r = -99;
      }
      
      return r;
   }
   /**
    * userWin method handles moving cards  
    * if the user wins the round,
    *
    */
   public void userWin()
   {
      userDeck.add(compDeck.get(0));
      userDeck.add(userDeck.get(0));
      
      userDeck.remove(userDeck.get(0));
      compDeck.remove(compDeck.get(0));
   }
   /**
    * compWin method handles moving cards  
    * if the computer wins the round,
    *
    */
   public void compWin()
   {
      compDeck.add(userDeck.get(0));
      compDeck.add(compDeck.get(0));
      
      compDeck.remove(compDeck.get(0));
      userDeck.remove(userDeck.get(0));
   }
   /**
    * method gets the image that relates to the card  
    * of index i in user's hand
    * @return ImageIcon
    * @param i int index
    */
   public ImageIcon getCardPicUser(int i)
   {
      String s = userDeck.get(i).cardPic();
      ImageIcon image = new ImageIcon(s);
      return image;
   }
   /**
    * method gets the image that relates to the card  
    * of index i in computer's hand
    * @return ImageIcon
    * @param i int index
    */
   public ImageIcon getCardPicComp(int i)
   {
      String s = compDeck.get(i).cardPic();
      ImageIcon image = new ImageIcon(s);
      return image;
   }
   /**
    * method checks if user hand is empty  
    * @return boolean
    */
   public boolean userIsEmpty()
   {
      boolean empty = false;
      if(userDeck.isEmpty() == true)
      {
         empty = true;
      }
      return empty;
   }
   /**
    * method checks if computer hand is empty  
    * @return boolean
    */
   public boolean compIsEmpty()
   {
      boolean empty = false;
      if(compDeck.isEmpty() == true)
      {
         empty = true;
      }
      return empty;
   }
   /**
    * method checks the size of the user's hand  
    * @return int
    */
   public int userDeckSize()
   {
      return userDeck.size();
   }
   /**
    * method checks the size of the computer's hand  
    * @return int
    */
   public int compDeckSize()
   {
      return compDeck.size();
   }
   /**
    * method turns size of user deck into a string  
    * @return String
    */
   public String userSizeToString()
   {
      String s = Integer.toString(userDeck.size());
      return s;
   }
   /**
    * method turns size of computer deck into a string  
    * @return String
    */
   public String compSizeToString()
   {
      String s = Integer.toString(compDeck.size());
      return s;
   }
}