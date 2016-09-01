import java.util.Scanner;


public class H4_31 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String binary;
		int deci = 0;
		int binarylength = 0;
		double placemulti;
		char cont = 'y';
		String validate = "^[01]+$";

		while (cont == 'y') {
			try {
				System.out.print("Enter a number in binary: ");
				binary = input.nextLine();

				if (binary.matches(validate)) {
					binarylength = binary.length();

					for (int i=0;i<binarylength;i++) {
						placemulti = Math.pow(2, i);
						deci = Double.valueOf(placemulti).intValue() * Character.getNumericValue(binary.charAt(binarylength - i - 1)) + deci;
					}

					System.out.printf("Your binary number, %s, is %d in decimal!\n", binary, deci);

					System.out.print("Another? (y/n): ");
					cont = input.nextLine().charAt(0);
				}
				else {
					System.out.println("Hey! That number isn't binary! Let's try that again!");
				}
			}
			catch (Exception ex) {
				input.nextLine();
				System.out.println("Oops! Something went wrong here, let's try that again!");
			}
		}
	}
}
