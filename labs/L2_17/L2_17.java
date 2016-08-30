import java.util.Scanner;

class L2_17 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int first;
		int second;
		int third;

		char cont = 'y';

		int largest;
		int smallest;

		try {
			while (cont == 'y') {
				System.out.print("Please enter an integer: ");
				first = input.nextInt();
				System.out.print("Please enter another integer: ");
				second = input.nextInt();
				System.out.print("Please enter one last integer: ");
				third = input.nextInt();

				System.out.printf("Sum: %d\n", first + second + third);
				System.out.printf("Average: %d\n", (first + second + third) / 3);
				System.out.printf("Product: %d\n", first * second * third);

				if (first >= second && first >= third) { 
					largest = first;
				} 
				else if (second >= first && second >= third) {
					largest = second;
				}
				else {
					largest = third;
				}

				if (first <= second && first <= third) { 
					smallest = first;
				} 
				else if (second <= first && second <= third) {
					smallest = second;
				}
				else {
					smallest = third;
				}

				System.out.printf("Largest: %d\n", largest);
				System.out.printf("Smallest: %d\n", smallest);

				System.out.print("Again? (y/n): ");
				cont = input.next().charAt(0);
			}
		}
		catch (Exception ex) {
			// clear the input buffer
			input.nextLine();
			System.out.println("Input Error!");
		}
	}
}
