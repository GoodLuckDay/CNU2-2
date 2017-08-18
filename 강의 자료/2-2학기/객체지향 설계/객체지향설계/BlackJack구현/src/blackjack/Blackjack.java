package blackjack;

import java.io.*;

/*
This program lets the user play Blackjack.  The computer
acts as the dealer.  The user has a stake of $100, and
makes a bet on each game.  The user can leave at any time,
or will be kicked out when he loses all the money.
House rules:  The dealer hits on a total of 16 or less
and stands on a total of 17 or more.  Dealer wins ties.
A new deck of cards is used for each game.
*/

public class Blackjack {
	static int money;
public static void main(String[] args) throws ClassNotFoundException{

             // Amount of money the user has.
   int bet;            // Amount user bets on a game.
   boolean userWins;   // Did the user win the game?
   
   TextIO.putln("Welcome to the game of blackjack.");
   TextIO.putln();
   
   money = 100;  // User starts with $100.
   
   while (true) {
       TextIO.putln("You have " + money + " dollars.");
       do {
          TextIO.putln("How many dollars do you want to bet?  (Enter 0 to end.)");
          TextIO.put("? ");
          bet = TextIO.getlnInt();
          if (bet < 0 || bet > money)
              TextIO.putln("Your answer must be between 0 and " + money + '.');
       } while (bet < 0 || bet > money);
       if (bet == 0)
          break;
       userWins = playBlackjack();
       if (userWins)
          money = money + bet;
       else
          money = money - bet;
       TextIO.putln();
       if (money == 0) {
          TextIO.putln("Looks like you've are out of money!");
          break;
       }
   }
   
   TextIO.putln();
   TextIO.putln("You leave with $" + money + '.');

} // end main()


static boolean playBlackjack() throws ClassNotFoundException{
      // Let the user play one game of Blackjack.
      // Return true if the user wins, false if the user loses.
   Deck deck;                  // A deck of cards.  A new deck for each game.
   BlackjackHand dealerHand;   // The dealer's hand.
   BlackjackHand userHand;     // The user's hand.
   
   deck = new Deck();
   dealerHand = new BlackjackHand();
   userHand = new BlackjackHand();

   /*  Shuffle the deck, then deal two cards to each player. */
   
   deck.shuffle();
   dealerHand.addCard( deck.dealCard() );
   dealerHand.addCard( deck.dealCard() );
   userHand.addCard( deck.dealCard() );
   userHand.addCard( deck.dealCard() );
   
   TextIO.putln();
   TextIO.putln();
   
   /* Check if one of the players has Blackjack (two cards totaling to 21).
      The player with Blackjack wins the game.  Dealer wins ties.
   */
   
   if (dealerHand.getBlackjackValue() == 21) {
        TextIO.putln("Dealer has the " + dealerHand.getCard(0)
                                + " and the " + dealerHand.getCard(1) + ".");
        TextIO.putln("User has the " + userHand.getCard(0)
                                  + " and the " + userHand.getCard(1) + ".");
        TextIO.putln();
        TextIO.putln("Dealer has Blackjack.  Dealer wins.");
        return false;
   }
   
   if (userHand.getBlackjackValue() == 21) {
        TextIO.putln("Dealer has the " + dealerHand.getCard(0)
                                + " and the " + dealerHand.getCard(1) + ".");
        TextIO.putln("User has the " + userHand.getCard(0)
                                  + " and the " + userHand.getCard(1) + ".");
        TextIO.putln();
        TextIO.putln("You have Blackjack.  You win.");
        return true;
   }
   
   /*  If neither player has Blackjack, play the game.  First the user 
       gets a chance to draw cards (i.e., to "Hit").  The while loop ends 
       when the user chooses to "Stand".  If the user goes over 21,
       the user loses immediately.
   */
   
   while (true) {
       
        /* Display user's cards, and let user decide to Hit or Stand. */

        TextIO.putln();
        TextIO.putln();
        TextIO.putln("Your cards are:");
        for ( int i = 0; i < userHand.getCardCount(); i++ )
           TextIO.putln("    " + userHand.getCard(i));
        TextIO.putln("Your total is " + userHand.getBlackjackValue());
        TextIO.putln();
        TextIO.putln("Dealer is showing the " + dealerHand.getCard(0));
        TextIO.putln();
        TextIO.put("Hit (H) or Stand (S) Save&Quit (Q) Load (L) ? ");
        char userAction;  // User's response, 'H' or 'S'.
        do {
           userAction = Character.toUpperCase( TextIO.getlnChar() );
           if ((userAction != 'H' && userAction != 'S')&&(userAction !='Q' && userAction !='L'))
              TextIO.put("Please respond H or S or Q or L :  ");
        } while ((userAction != 'H' && userAction != 'S')&&(userAction !='Q' && userAction !='L'));

        /* If the user Hits, the user gets a card.  If the user Stands,
           the loop ends (and it's the dealer's turn to draw cards).
        */

        if ( userAction == 'S' ) {
                // Loop ends; user is done taking cards.
            break;
        }
        else if(userAction == 'H'){  // userAction is 'H'.  Give the user a card.  
                // If the user goes over 21, the user loses.
            Card newCard = deck.dealCard();
            userHand.addCard(newCard);
            TextIO.putln();
            TextIO.putln("User hits.");
            TextIO.putln("Your card is the " + newCard);
            TextIO.putln("Your total is now " + userHand.getBlackjackValue());
            if (userHand.getBlackjackValue() > 21) {
                TextIO.putln();
                TextIO.putln("You busted by going over 21.  You lose.");
                TextIO.putln("Dealer's other card was the " 
                                                   + dealerHand.getCard(1));
                return false;  
            }
        }
        else if(userAction == 'Q'){
        	try{
     
        		FileOutputStream fileout = new FileOutputStream("./tmp/deck.ser");
        		ObjectOutputStream out = new ObjectOutputStream(fileout);
        		out.writeObject(deck);
        		out.writeObject(dealerHand);
        		out.writeObject(userHand);
        		out.writeInt(money);
        		out.close();
        		fileout.close();
        		System.exit(0);
        	}
        	catch(IOException i){
        		i.getStackTrace();
        	}
        }
        else if(userAction == 'L'){
        	try{
        		FileInputStream fileIn = new FileInputStream("./tmp/deck.ser");
        		ObjectInputStream in = new ObjectInputStream(fileIn);
        		deck = (Deck) in.readObject(); 
        		dealerHand = (BlackjackHand) in.readObject();
        		userHand = (BlackjackHand) in.readObject();
        		money = in.readInt();
        		in.close();
        		fileIn.close();
        	}
        	catch(IOException i){
        		i.getStackTrace();
        	}
        }
   } // end while loop
   
   /* If we get to this point, the user has Stood with 21 or less.  Now, it's
      the dealer's chance to draw.  Dealer draws cards until the dealer's
      total is > 16.  If dealer goes over 21, the dealer loses.
   */

   TextIO.putln();
   TextIO.putln("User stands.");
   TextIO.putln("Dealer's cards are");
   TextIO.putln("    " + dealerHand.getCard(0));
   TextIO.putln("    " + dealerHand.getCard(1));
   while (dealerHand.getBlackjackValue() <= 16) {
      Card newCard = deck.dealCard();
      TextIO.putln("Dealer hits and gets the " + newCard);
      dealerHand.addCard(newCard);
      if (dealerHand.getBlackjackValue() > 21) {
         TextIO.putln();
         TextIO.putln("Dealer busted by going over 21.  You win.");
         return true;
      }
   }
   TextIO.putln("Dealer's total is " + dealerHand.getBlackjackValue());
   
   /* If we get to this point, both players have 21 or less.  We
      can determine the winner by comparing the values of their hands. */
   
   TextIO.putln();
   if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
      TextIO.putln("Dealer wins on a tie.  You lose.");
      return false;
   }
   else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
      TextIO.putln("Dealer wins, " + dealerHand.getBlackjackValue() 
                       + " points to " + userHand.getBlackjackValue() + ".");
      return false;
   }
   else {
      TextIO.putln("You win, " + userHand.getBlackjackValue() 
                       + " points to " + dealerHand.getBlackjackValue() + ".");
      return true;
   }

}  // end playBlackjack()


} // end class Blackjack