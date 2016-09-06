import java.util.Scanner;

/**
* This class will take in three cards as input and will output the
*  recommended action.  Valid inputs are the numbers 2 through 9, then
* the letters J, Q, K, and A to signify the Jack, Queen, King, and Ace
* of any suit respectively.
* 
* @author jcovey
*
*/
public class BasicStrategy {

	public static void main(String[] args) {

	// Let's get our input values here.
			
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the dealer's up card: ");
		System.out.print("Enter the player's first card: ");
		String pCard1 = input.next();
		System.out.print("Enter the player's second card: ");
		String pCard2 = input.next();

		String output = "Invalid Output";

		// Set up some variables to hold the actual numerical values of the
		// cards and of the hand.  Sometimes we will want to use the actual
		// names of the cards but other times it will be more useful to use
		// their values.
		int pCard1Value = ComputeCardValue(pCard1);
		int pCard2Value = ComputeCardValue(pCard2);
		int dCardValue = ComputeCardValue(dCard);
		int cardsum = pCard1Value + pCard2Value;

		// Let's find out what we are supposed to do!

		// ************ WRITE YOUR CODE HERE ******************* //

		// OK, we're all done now we should know our move and can print it!

		System.out.println("Your move: " + output);
	}

	/**
	* This method computes the numerical value of a card
	* that is dealt.
	* 
	* @param card The string representation of the card
	* @return The numerical value of the card
	*/
	public static int ComputeCardValue(String card) {
		if (card.equalsIgnoreCase("A")) {
			return 11;
		} else if (card.equalsIgnoreCase("K")
				|| card.equalsIgnoreCase("Q")
				|| card.equalsIgnoreCase("J")) {
			return 10;
		} else {
			return Integer.parseInt(card);
		}
	}
}
