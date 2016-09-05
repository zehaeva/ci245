import java.util.Scanner;

public class J_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] to_be_sorted;
		char hold;

		String inputs;

		System.out.printf("Please enter an arbitrary amount of integers, when you are done please press the enter key: ");
		inputs = input.nextLine();

		to_be_sorted = new int[inputs.length()];

		for (int i=0;i<inputs.length();i++) {
			hold = inputs.charAt(i);
			if (Character.isDigit(hold)) {
				to_be_sorted[i] = (int) hold;
			}
		}
	}
}


