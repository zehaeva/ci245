import java.util.Scanner;

public class L2_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int first;
		int second;
		char not_done = 'y';

		while (not_done == 'y') {
			try {
				System.out.print("Please enter the first integer: ");
				first = input.nextInt();

				System.out.print("Please enter the second integer: ");
				second = input.nextInt();

				System.out.printf("Sum: %d\n", first + second);
				System.out.printf("Product: %d\n", first * second);
				System.out.printf("Difference: %d\n", first - second);
				System.out.printf("Quotient: %d\n", first / second);
				
				System.out.print("Another? (y/n): ");
				not_done = input.next().charAt(0);	
			}
			catch (Exception ex) {
				// this should clear the input buffer
				input.nextLine();
				System.out.print("Invalid Input!\n");
			}
		}
	}
}
