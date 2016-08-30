import java.util.Scanner;
import java.util.InputMismatchException;

public class L2_28 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int radius;
		char cont = 'y';

		try {
			while (cont == 'y') {
		  		System.out.print("Enter the radius of a circle: ");
				radius 	= input.nextInt();

				System.out.printf("Diameter: %f", 2f * radius);
				System.out.printf("Circumfrence: %f", Math.PI * radius * 2);
				System.out.printf("Diameter: %f", Math.PI * radius * radius);

		  		System.out.print("Again? (y/n): ");
				cont = input.next().charAt(0);
			}
		}	
		catch (InputMismatchException ex) {
			// clear the input buffer
			System.out.println("Input Error!");
		}
		catch (Exception ex) {
			System.out.println("Unexpected Error!");
		}
		finally {
			input.nextLine();
		}		
	}
}
