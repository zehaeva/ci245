import java.util.Scanner;
import java.util.Arrays;

public class L7_19 {

	public static void main(String[] args) {
		boolean[] seats = new boolean[10];
		Arrays.fill(seats, false);
		Scanner input = new Scanner(System.in);

		int seat_type;
		int found_seat = -1;
		char change = 'n';
		String seat_class;

		System.out.println("Welcome to Java Airlines!");

		System.out.print("Please type 1 for First Class or type 2 for Economy: ");
		seat_type = input.nextInt();

		if (seat_type == 1) {
			for (int i=0;i<5;i++) {
				if (seats[i] == false) {
					found_seat = i;
					seats[i] = true;
				}
			}

			if (found_seat < 0) {
				seat_class = "Economy";
				System.out.printf("Sorry we didn't find an available seat, is %s acceptable? (y/n): ", seat_class);
				change = input.nextLine().charAt(0);
			}	
		}
		else if (seat_type == 2) {
			for (int i=5;i<10;i++) {
				if (seats[i] == false) {
					found_seat = i;
					seats[i] = true;
				}
			}

			if (found_seat < 0) {
				seat_class = "First Class";
				System.out.printf("Sorry we didn't find an available seat, is %s acceptable? (y/n): ", seat_class);
				change = input.nextLine().charAt(0);
			}
		}
		
		if (found_seat < 0 && change == 'y') {
			
		}	
	}
}
