import java.util.Scanner;

/**
 * Accepts a string and then outputs the words reversed
 */
public class L14_9 {
	/**
	 * Accepts a string and then outputs the words reversed
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

			output = one.split(" ");

			for (int i=output.length - 1;i>=0;i--) {
				System.out.printf("%s ", output[i]);
			}

			System.out.print("\nAgain? (y/n): ");
			cont = input.nextLine().charAt(0);
		}
	}
}
