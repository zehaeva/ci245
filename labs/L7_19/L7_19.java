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
			seat_type = 0;

			while (seat_type == 0) {
				try {
					System.out.print("Please type 1 for First Class or type 2 for Economy: ");
					seat_type = input.nextInt();
				}
				catch (Exception ex) {
					input.nextLine();
					System.out.println("Sorry I didn't quite understand that!");
				}
			}

			while (cont == 'y') {
				if (seat_type == 1) {
					for (int i=0;i<5;i++) {
						if (seats[i] == false) {
							filled_seats++;
							cont = 'n';
							found_seat = i;
							seats[i] = true;
							print_pass(i, seat_type);
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
							print_pass(i, seat_type);
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

	public static String seat_class(int class_id) {
		if (class_id == 1) {
			return "First Class";
		}
		else if (class_id == 2) {
			return "Economy";
		}
		else {
			return "Unknown";
		}
	}

	public static void find_seat(int section_start, int section_end, int class_id, boolean[] seating_chart) {
		int seat_type;
		Scanner input = new Scanner(System.in);
		int found_seat = 0;
		int filled_seats = 0;
		char change;
		char cont;
		char another = 'y';

		for (int i=section_start;i<section_end;i++) {
			if (seating_chart[i] == false) {
				filled_seats++;
				cont = 'n';
				found_seat = i;
				seating_chart[i] = true;
				print_pass(i, class_id);
				break;
			}
		}

		if (found_seat < 0) {
			System.out.printf("Sorry we didn't find an available seat, is %s acceptable? (y/n): ", seat_class(2));
			change = input.next().charAt(0);
			if (change == 'y') {
				seat_type = 1;
			}
			else {
				System.out.println("Next flight leaves in 3 hours");
			}
		}
	}

	public static void print_pass(int seat_number, int class_id) {
		System.out.printf("Your seat has been reserved! Your seat number is %d\n", seat_number);

		System.out.printf("****************************************************\n");
		System.out.printf("** Boarding Pass                                  **\n");
		System.out.printf("** Seat# %-26d %-13s **\n", seat_number, seat_class(class_id));
		System.out.printf("**                                                **\n");
		System.out.printf("****************************************************\n");
	}
}
