import java.util.Scanner;

public class L7_19 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		boolean[] seats = {false, false, false, false, false, false, false, false, false, false};
		int seat_type;
		int found_seat = -1;
		char change = 'n';

		System.out.println("Welcome to Java Airlines!");

		System.out.print("Please type 1 for First Class or type 2 for Economy: ");
		seat_type = input.nextInt();

		if (seat_type == 1) {
			
		}
		else if (seat_type == 2) {

		}

	}

	public static boolean find_seat(int start, int end, String seat_class) {
		int found_seat = -1;
		char change = 'n';

		for (int i=start;i<end;i++) {
			if (seats[i] == false) {
				found_seat = i;
			}
		}

		if (found_seat < 0) {
			System.out.printf("Sorry we didn't find an available seat, is %s acceptable? (y/n): ", seat_class);
			change = input.nextLine().charAt(0);
		}
	}
}
