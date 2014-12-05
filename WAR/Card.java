import javax.swing.*;

public class Card
{
   //Declare all suit/face card variables 
   public static final int SPADES = 1;
   public static final int DIAMONDS= 2;
   public static final int HEARTS = 3;
   public static final int CLUBS = 4;
   public static final int ACE = 1;
   public static final int JACK = 11;
   public static final int QUEEN = 12;
   public static final int KING = 13;
   public static final int DEFAULT = 1;
   public String cardPic;
   private int rank;
   private int suit;
   private ImageIcon icon;
   
   //Constructor to create card and set rank and suit
   //@param newSuit is the number value of the new suit
   //@param newRank is the number of the cards rank
   public Card(int newSuit, int newRank)
   {
      //Check to see if arguments are valid, if not set to default values
      //Otherwise set suit/rank as arguments
      if (newSuit != SPADES && newSuit != CLUBS && 
            newSuit != HEARTS && newSuit != DIAMONDS)
         {suit = DEFAULT;}
      else
         {suit = newSuit;}
      
      if ((newRank < ACE || newRank > KING))
         {rank = DEFAULT;}
      else 
         {rank = newRank;}
      
   }
   //Copy Constructor
   public Card(Card otherCard)
   {
      int newRank = otherCard.rank;
      int newSuit = otherCard.suit;
      
      if (newSuit != SPADES && newSuit != CLUBS && 
            newSuit != HEARTS && newSuit != DIAMONDS)
         {suit = DEFAULT;}
      else
         {suit = newSuit;}
      
      if ((newRank < ACE || newRank > KING))
         {rank = DEFAULT;}
      else 
         {rank = newRank;}
   }
   //Get the file name for the card picture
   //@return String representing filename
   public String cardPic()
   {
      //Use if/else statement to make string value of rank   
      if (rank == ACE) 
         {cardPic = "ace";}
      else if (rank == JACK)
         {cardPic = "jack";}
      else if (rank == QUEEN)
         {cardPic = "queen";}
      else if (rank == KING)
         {cardPic = "king";}
      else
         {cardPic = (Integer.toString(rank));}
       
      
      //Use if/else statement to make string vlaue of suit
      if (suit == SPADES)
         {cardPic += "s";}
      else if (suit == CLUBS)
         {cardPic += "c";}
      else if (suit == HEARTS)
         {cardPic += "h";}
      else if (suit == DIAMONDS)
         {cardPic += "d";}
         
      cardPic += ".jpg";
      
      return cardPic;
   }
   
   //Method to return suit value
   //@return suit is numerical suit value
   public int getSuit()
   {
      return suit;
   }
   
   //Method to return rank value
   //@return suit is numerical rank value
   public int getRank()
   {
      return rank;
   }
   
   //Method to return the image icon
   //@return icon an ImageIcon object
   public ImageIcon getIcon()
   {
      return icon;
   }
   
   //Checks if calling card object and another are equal
   //@param another Card object to compare to
   //@return a boolean to show rank equality or not
   public boolean compareRank(Card otherCard)
   {
      //Compare two cards, return appropriate boolean
      if (this.getRank() == otherCard.getRank())
         return true;
      return false;
   }
   
   //Checks if calling card object and another are equal
   //@param another Card object to compare to
   //@return a boolean to show suit equality or not
   public boolean compareSuit(Card otherCard)
   {
      //Compare two cards, return appropriate boolean
      if (this.getSuit() == otherCard.getSuit())
         return true;
      return false;
   }

}