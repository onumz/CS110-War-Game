/**
 * Representation of a Deck of cards.  
 * Initialized to a standard 52 card deck. 
 *
 * 
 */

import java.util.Random;
import java.util.ArrayList;

public class Deck1
{
   /** 
   *  Number of cards in standard deck {@value #CARDS_IN_DECK}
   **/
   final int CARDS_IN_DECK = 52;

   /** The collection of Cards */
   private ArrayList<Card> deck;
   
   /**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.  
    */
   public Deck1()
   {
            freshDeck();
   }
   
   /**
    * Create a new collection of 52 cards, in sorted order
    */
   public void freshDeck()
   {
      deck = new ArrayList<Card>();
 
      for (int s=Card.SPADES;s<=Card.CLUBS;s++)
      {
         for (int r = Card.ACE; r<=Card.KING;r++)
         {
           Card card = new Card(s,r);
           deck.add(card);
         }
      }
     
   
   }
   /** 
     * Remove and return the top Card on the Deck
     * @return A reference to a Card that was top on the Deck
     */
   public Card dealCard()
   {
      Card c = deck.remove(0);  //  remove it (returns removed object)
      return c;
   }
   /** 
     * Return current number of Cards in Deck
     * @return number of Cards in Deck
     */

   public int cardsRemaining()
   {  
      return deck.size();
   }
   /**
     *Print all the cards in the deck
     *
     */
   public void printAll()
   {
      for (int i = 0; i < deck.size(); i++)
      {
         System.out.println(deck.get(i).cardPic());
      }
   }
   
   /** 
     * Randomize the order of Cards in Deck
     */

   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   /** 
     * Determine if Deck is empty
     * @return true if there are no more cards, false otherwise
     */
   
   public boolean isEmpty()
   {
      boolean empty = false;
      if(deck.size()==0)
      {
         empty = true;
      }
      return empty;  

   }
}
