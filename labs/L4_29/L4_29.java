import java.util.Scanner;

public class L4_29 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int side = 0;
		char again = 'y';

		while(again == 'y') {
			try {
				System.out.print("Entera number from 1 to 20: ");
				side = input.nextInt();

				if (side >= 1 && side <= 20) {
					for (int i=0;i<side;i++) {
						if (i == 0 || i == side - 1) {
							for (int j=0;j<side;j++) {
								System.out.print('*');
							}
						}
						else {
							System.out.print('*');
							for (int j=2;j<side;j++) {
								System.out.print(' ');
							}
							System.out.print('*');
						}
						System.out.print('\n');
					}
					System.out.print("Again? (y/n): ");
					again = input.next().charAt(0);
				}
			}
			catch (Exception ex) {
				input.nextLine();
				System.out.println("Sorry there was an error with your input!");
			}
		}
	}
}
