import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * Class to write a file
 * The first line of the file should be a random (see Random class) integer between 10 and 200, i
 * inclusive of both, we will refer to this number as N.  
 * The second line of the file should be a random integer in the set {5, 6, 7, 8, 100000}.
 * Create a random number of lines after these two.
 * Each of the random lines should contain two integers between 1 and N separated by a space. 
 * None of these lines should have the same number (meaning "6 6" is not allowed). 
 * None of these lines should repeat (meaning if you have "8 3" you cannot have "8 3" again). 
 * None of these lines should repeat in reverse (meaning you one line is "9 15" there cannot be a "15 9").
 */
public class J_14 {
	/**
	 * main function
	 * @param args not used
	 */
	public static void main(String[] args) {
		Random rng = new Random();
		ArrayList<String> output = new ArrayList<String>();

	//  get number of guests
		int n = rng.nextInt(190) + 11;

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

		WriteTextFile(output, "random_file.txt");
	}

	/**
	 * calculates the maximum amount of combos of hate in a list of size n
	 * @param n max number for the combos
	 * @return number of combos
	 */
	public static int get_hate_combos(int n) {//{{{
		int count = 0;
		for (int i=1;i<n;i++) {
			count += i;
		}
		return count;
	}//}}}

	/**
	 * validates that the pair isn't already in the list
	 * @param one first guest to check
	 * @param two second guest to check
	 * @param list the array of who hates who
	 * @return if they're valid to be added 
	 */
	public static boolean check_pair(int one, int two, boolean[][] list) {//{{{
		if (!list[one][two] && !list[two][one] && two != one) {
			return true;
		}
		else {
			return false;
		}
	}//}}}

	/**
	 * Code stolen from the instructor Covey
	 * @param fileName the name of the file to read
	 * @return arraylist of the file
	 */
	public static ArrayList<String> ReadTextFile(String fileName) {//{{{
		// Now we will read all of the lines back that we just wrote
		Path path = Paths.get(fileName);
		ArrayList<String> linesToRead = new ArrayList<String>();

		try {
			// Need to cast the return result to an ArrayList
			linesToRead = (ArrayList<String>)Files.readAllLines(path, StandardCharsets.UTF_8);
			
		} catch (IOException e) {
			System.out.println("There was a problem getting to the file!");
		}	

		return linesToRead;
	}//}}}

	/**
	 * Code stolen from the instructor Covey
	 * @param input ArrayList of strings to be written
	 * @param fileName name of file to write to
	 */
	public static void WriteTextFile(ArrayList<String> input,  String fileName) {
		// We need to set up a path to a file, really its just
		// a text string to the path wrapped in an object
		Path path = Paths.get(fileName);

		// Try and catch prevents "typical" errors from breaking the program.
		// For some error types a try/catch block is REQUIRED to compile.  This
		// is one of those instances.
		try {
			Files.write(path, input, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
		} catch (IOException e) {
			System.out.println("There was a problem getting to the file!");
		}
	}

}
