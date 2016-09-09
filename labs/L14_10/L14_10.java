import java.util.Scanner;

/**
 * Accepts a string and then outputs the words in both upper and lower case 
 */
public class L14_10 {
	/**
	 * Accepts a string and then outputs the words in both upper and lower case 
	 * @param args String arguments
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String one; 
		String[] output;
		int val;
		char cont = 'y';

		while (cont == 'y') {
			System.out.print("Enter a string: ");
			one = input.nextLine();

			System.out.printf("%s\n", one.toUpperCase());
			System.out.printf("%s\n", one.toLowerCase());

			System.out.print("Again? (y/n): ");
			cont = input.nextLine().charAt(0);
		}
	}
}
