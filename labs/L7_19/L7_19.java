import java.util.Scanner;
import java.util.Arrays;

public class L7_19 {

	public static void main(String[] args) {
		boolean[] seats = new boolean[10];
		Arrays.fill(seats, false);
		Scanner input = new Scanner(System.in);

		int seat_type;
		int found_seat;
		int filled_seats = 0;
		char change;
		char cont;
		char another = 'y';
		String seat_class;

		System.out.println("Welcome to Java Airlines!");

		while (another =='y') {
			cont = 'y';
			found_seat = -1;
			change = 'n';


			System.out.print("Please type 1 for First Class or type 2 for Economy: ");
			seat_type = input.nextInt();

			while (cont == 'y') {
				if (seat_type == 1) {
					for (int i=0;i<5;i++) {
						if (seats[i] == false) {
							filled_seats++;
							cont = 'n';
							found_seat = i;
							seats[i] = true;
							print_pass(i, "First Class");
							break;
						}
					}

					if (found_seat < 0) {
						seat_class = "Economy";
						System.out.printf("Sorry we didn't find an available seat, is %s acceptable? (y/n): ", seat_class);
						change = input.next().charAt(0);
						if (change == 'y') {
							seat_type = 2;
						}
						else {
							System.out.println("Next flight leaves in 3 hours");
						}
					}	
				}
				else if (seat_type == 2) {
					for (int i=5;i<10;i++) {
						if (seats[i] == false) {
							filled_seats++;
							cont = 'n';
							found_seat = i;
							seats[i] = true;
							print_pass(i, "Economy");
							break;
						}
					}

					if (found_seat < 0) {
						seat_class = "First Class";
						System.out.printf("Sorry we didn't find an available seat, is %s acceptable? (y/n): ", seat_class);
						change = input.next().charAt(0);
						if (change == 'y') {
							seat_type = 1;
						}
						else {
							System.out.println("Next flight leaves in 3 hours");
						}
					}
				}
			}

			if (filled_seats >= 10) {
				System.out.println("This flight is fully booked! The next flight leaves in 3 horus");
				another = 'n';
			}
			else {
				System.out.print("Do you want to reserve another seat? (y/n): ");
				another = input.next().charAt(0);
			}
		}
	}

	public static void print_pass(int seat_number, String seat_class) {
		System.out.printf("Your seat has been reserved! Your seat number is %d\n", seat_number);

		System.out.printf("****************************************************\n");
		System.out.printf("** Boarding Pass                                  **\n");
		System.out.printf("** Seat# %-26d %-13s **\n", seat_number, seat_class);
		System.out.printf("**                                                **\n");
		System.out.printf("****************************************************\n");
	}
}
