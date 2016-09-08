import java.util.Scanner;

/**
 * J_10 implements Print and Join for arrays
 */
public class J_10 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr;
		int count = 0;
		String inputs;
		String[] process;
		String validate = "^[0-9\\-]+$";

		System.out.print("Please enter numbers for the array, separated by spaces: ");
		inputs = input.nextLine();
		process = inputs.split(" ");

		for (String var: process) {
			if (var.matches(validate)) {
				count++;
			}
		}

		arr = new int[count];
		count = 0;
		for (String var: process) {
			if (var.matches(validate)) {
				arr[count] = Integer.parseInt(var);
				count++;
			}
		}

		Print(arr);
	}

	/**
	 * Prints an array as a comma separated list
	 * @param array array to be printed
	 */
	public static void Print(int[] array) {
		System.out.printf("%s\n", Join(array, ","));
	}
	
	/**
	 * Joins an array into a string separated by the given string
	 * @param array	array to be joined
	 * @param str 	string to be used to separate the array
	 */
	public static String Join(int[] array, String str) {
		String hold = "";
		for (int val: array) { 
			if (hold.length() > 0) {
				hold += str + " " + val;
			}
			else {
				hold = "" + val;
			}
		}

		return hold;
	}
}

			
