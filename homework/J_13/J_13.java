import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;

/**
 * class for homework J_13
 * compares two files
 */
public class J_13 {
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
		
		while (cont == 'y') {
			System.out.print("Please enter the name of two files to compare: ");
			name_one = input.nextLine();
			System.out.print("Now the second file name: ");
			name_two = input.nextLine();
			
			file_one = ReadTextFile(name_one);
			file_two = ReadTextFile(name_two);

			if (file_one.equals(file_two)) {
				System.out.println("The files are the same!");
			}
			else {
				System.out.println("The files are the different!!");
			}
			
			System.out.print("Compare two more files? (y/n): ");
			cont = input.nextLine().charAt(0);
		}
	}

	/**
	 * Code stolen from the instructor Coveny J_11
	 * @param fileName the name of the file to read
	 * @return arraylist of the file
	 */
	public static ArrayList<String> ReadTextFile(String fileName) {
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
	}
}
