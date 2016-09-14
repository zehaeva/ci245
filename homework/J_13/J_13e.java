import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;

/**
 * Extra Credit J.13
 * compares two files
 */
public class J_13e {
	/**
	 * Main function for J_13
	 * @param args unused
	 */
	public static void main (String[] args) {
		ArrayList<String> file_one;
		ArrayList<String> file_two;
		String name_one;
		String name_two;
		Scanner input = new Scanner(System.in);
		char cont = 'y';
		double e_distance = 0.0;
		
		while (cont == 'y') {
			System.out.print("Please enter the name of two files to compare: ");
			name_one = input.nextLine();
			System.out.print("Now the second file name: ");
			name_two = input.nextLine();
			
			file_one = ReadTextFile(name_one);
			file_two = ReadTextFile(name_two);

			e_distance = euclideanDistance(file_one.toString(), file_two.toString());

			if (e_distance == 0.0) {
				System.out.printf("The files are the same! Euclidean Distance is %f\n", e_distance);
			}
			else {
				System.out.printf("The files are the different!! Euclidean Distance is %f\n", e_distance);
			}
			
			System.out.print("Compare two more files? (y/n): ");
			cont = input.nextLine().charAt(0);
		}
	}
	 
	/**
	 * calculates the euclideanDistance between any two vectors
	 * @param arr_one first vector
	 * @param arr_two second vector
	 * @return euclideanDistance between the inputs
	 */
	public static double euclideanDistance(String arr_one, String arr_two) {
		double sum = 0.0;
		String tmp;
		if (arr_two.length() < arr_one.length()) {
			tmp = arr_two;
			arr_two = arr_one;
			arr_one = tmp;
		}

		for (int i=0;i<arr_one.length();i++) {
			sum += Math.pow(((double)arr_one.charAt(i) - (double)arr_two.charAt(i)), 2);
		}

		for (int i=arr_one.length();i<arr_two.length();i++) {
			sum += Math.pow((double)arr_two.charAt(i), 2);
		}

		return Math.sqrt(sum);
	}

	/**
	 * Code stolen from the instructor Covey J_11
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
}
