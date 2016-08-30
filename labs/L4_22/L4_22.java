import java.util.Scanner;

public class L4_22 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n;
		char cont = 'y';

		try {
			while (cont == 'y') {
				System.out.print("Enter the number of cycles: ");
				n = input.nextInt();

				System.out.println("N\t10*N\t100*N\t1000*N");
				for (int i=0;i<n;i++) {
					System.out.printf("%d\t%d\t%d\t%d\n", i, i * 10, i * 100, i * 1000);
				}

				System.out.print("Again? (y/n): ");
				cont = input.next().charAt(0);
			}
		}
		catch (Exception ex) {
			input.nextLine();
			System.out.println("Input Error!");
		}
	}
}
