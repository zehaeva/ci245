import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class J_14 {
	public static void main(String[] args) {
		Random rng = new Random();
		ArrayList<String> output = new ArrayList<String>();

	//  get number of guests
		int n = rng.nextInt(10) + 11;

		int hate_combos = get_hate_combos(n);
		int hate_count = rng.nextInt(hate_combos) + 1;
		int hate_one;
		int hate_two;

		boolean[][] hate_list = new boolean[n][n]; 
		for (boolean[] list: hate_list) {
			Arrays.fill(list, false); 
		}

		System.out.printf("n: %d\nmax_combos: %d\nhate_count: %d\n", n, hate_combos, hate_count); 

	//  get number of people per table
		output.add("" + n);
		switch(rng.nextInt(5)) {
			case 0:
				output.add("5");
				break;
			case 1:
				output.add("6");
				break;
			case 2:
				output.add("7");
				break;
			case 3:
				output.add("8");
				break;
			default:
				output.add("100000");
		}

	//  generate list of those who hate each other
		int i = 0;
		while (i < hate_count) {
			hate_one = rng.nextInt(n);
			hate_two = rng.nextInt(n);

		//  if this pair doesn't exist then store it
			if (check_pair(hate_one, hate_two, hate_list)) {
				hate_list[hate_one][hate_two] = true;
				output.add(hate_one + " " + hate_two);
				i++;
			}
		}

		for (String val: output) {
			System.out.printf("%s\n", val);
		}

	}

//  calculates the maximum amount of combos of hate in a list of size n
	public static int get_hate_combos(int n) {
		int count = 0;
		for (int i=1;i<n;i++) {
			count += i;
		}
		return count;
	}

//  validates that the pair isn't already in the list
	public static boolean check_pair(int one, int two, boolean[][] list) {
		if (!list[one][two] && !list[two][one] && two != one) {
			return true;
		}
		else {
			return false;
		}
	}
}
