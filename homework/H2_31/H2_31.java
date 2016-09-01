import java.util.Scanner;

public class H2_31 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int max_n;
		char cont = 'y';

		while (cont == 'y') {
			try {
				System.out.print("Enter the max number to compute: ");
				max_n = input.nextInt();

				System.out.printf("number\tsquare\tcube\n");
				for (int i=0;i<=max_n;i++) {
					System.out.printf("%d\t%d\t%d\n", i, i*i, i*i*i);
				}

				System.out.print("Do you wish to run this again? (y/n): ");
				cont = input.next().charAt(0);
			}
			catch (Exception ex) {
				input.nextLine();
				System.out.println("Oh no! Something went terribly wrong! Please try again!");
			}
		}
	}
}
