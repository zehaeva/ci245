import java.util.Scanner;
import java.util.Hashtable;

/**
* This class will take in three cards as input and will output the
*  recommended action.  Valid inputs are the numbers 2 through 9, then
* the letters J, Q, K, and A to signify the Jack, Queen, King, and Ace
* of any suit respectively.
* 
* @author jcovey
*
*/
public class J_6 {

	public static void main(String[] args) {

	// Let's get our input values here.
			
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the dealer's up card: ");
		String dCard = input.next();
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
		output = player_action(pCard1, pCard2, dCardValue);

		// OK, we're all done now we should know our move and can print it!

		System.out.println("Your move: " + strat(output));
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

	public static String strat(String abb) {
		switch (abb) {
			case "H": return "Hit";
			case "D": return "Double Down";
			case "U": return "Surrender";
			case "S": return "Stand";
			case "P": return "Split";
		}
		return "Hit";
	}

	public static String player_action(String playerCard1, String playerCard2, int dealer) {
		int d_index = dealer - 2;
		int card1 = ComputeCardValue(playerCard1);
		int card2 = ComputeCardValue(playerCard2);
	//	encode matrix
		String[][] actions = {{"H","H","H","H","H","H","H","H","H","H",},
							  {"H","D","D","D","D","H","H","H","H","H",},
							  {"D","D","D","D","D","D","D","D","H","H",},
							  {"D","D","D","D","D","D","D","D","D","H",},
							  {"H","H","S","S","S","H","H","H","H","H",},
							  {"S","S","S","S","S","H","H","H","H","H",},
							  {"S","S","S","S","S","H","H","H","H","H",},
							  {"S","S","S","S","S","H","H","H","U","H",},
							  {"S","S","S","S","S","H","H","U","U","U",},
							  {"S","S","S","S","S","S","S","S","S","S",},
							  {"S","S","S","S","S","S","S","S","S","S",},
							  {"S","D","D","D","D","S","S","H","H","H",},
							  {"H","D","D","D","D","H","H","H","H","H",},
							  {"H","H","D","D","D","H","H","H","H","H",},
							  {"H","H","D","D","D","H","H","H","H","H",},
							  {"H","H","H","D","D","H","H","H","H","H",},
							  {"H","H","H","D","D","H","H","H","H","H",},
							  {"P","P","P","P","P","P","P","P","P","P",},
							  {"P","P","P","P","P","P","P","P","P","P",},
							  {"S","S","S","S","S","S","S","S","S","S",},
							  {"P","P","P","P","P","S","P","P","S","S",},
							  {"P","P","P","P","P","P","H","H","H","H",},
							  {"H","P","P","P","P","H","H","H","H","H",},
							  {"D","D","D","D","D","D","D","D","D","H",},
							  {"H","H","H","H","H","H","H","H","H","H",},
							  {"H","H","P","P","P","P","H","H","H","H",},
							  {"H","H","P","P","P","P","H","H","H","H",},
						     };
		if (playerCard1 == playerCard2) {
			switch(card1) {
				case 2: return actions[26][d_index];
				case 3: return actions[25][d_index];
				case 4: return actions[24][d_index];
				case 5: return actions[23][d_index];
				case 6: return actions[22][d_index];
				case 7: return actions[21][d_index];
				case 8: return actions[20][d_index];
				case 9: return actions[19][d_index];
				case 10: return actions[18][d_index];
				case 11: return actions[17][d_index];
			}
		}
		else if (card1 == 11 || card2 == 11) {
			if (card1 == 2 || card2 == 2) {
				return actions[16][d_index];
			}
			else if (card1 == 3 || card2 == 3) {
				return actions[15][d_index];
			}
			else if (card1 == 4 || card2 == 4) {
				return actions[14][d_index];
			}
			else if (card1 == 5 || card2 == 5) {
				return actions[13][d_index];
			}
			else if (card1 == 6 || card2 == 6) {
				return actions[12][d_index];
			}
			else if (card1 == 7 || card2 == 7) {
				return actions[11][d_index];
			}
		    else if (card1 >= 8 || card2 >= 8) {
				return actions[10][d_index];
			}
		}
		else {
			if (card1 + card2 <= 8) {
				return actions[0][d_index];
			}
			else if (card1 + card2 >= 17) {
				return actions[9][d_index];
			}
			else if (card1 + card2 == 16) {
				return actions[8][d_index];
			}
			else if (card1 + card2 == 15) {
				return actions[7][d_index];
			}
			else if (card1 + card2 == 14) {
				return actions[6][d_index];
			}
			else if (card1 + card2 == 13) {
				return actions[5][d_index];
			}
			else if (card1 + card2 == 12) {
				return actions[4][d_index];
			}
			else if (card1 + card2 == 11) {
				return actions[3][d_index];
			}
			else if (card1 + card2 == 10) {
				return actions[2][d_index];
			}
			else if (card1 + card2 == 9) {
				return actions[1][d_index];
			}
		}

		return "H";
	}
}
