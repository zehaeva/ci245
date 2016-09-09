import java.util.Scanner;

public class L14_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String one; 
		String two;
		String output;
		int val;
		char cont = 'y';

		while (cont == 'y') {
			System.out.print("Enter the first string: ");
			one = input.nextLine();

			System.out.print("Enter the second string: ");
			two = input.nextLine();

			val = one.compareTo(two);
			if (val > 0) {
				output = "less than";	
			} 
			else if ( val < 0) {
				output = "greater than";
			}
			else {
				output = "equal to";
			}

			System.out.printf("\"%s\" is %s \"%s\"\n", one, output, two);

			System.out.print("Again? (y/n): ");
			cont = input.nextLine().charAt(0);
		}
	}
}
