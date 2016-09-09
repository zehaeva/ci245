import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * In this exercise create ReadTextFile and WriteTextFile static methods.  
 * ReadTextFile will take in a filename and return an ArrayList<String> 
 * object with each element representing a line of the text file.  
 * WriteTextFile will take in an ArrayList<String> object and a filename 
 * then write the ArrayList<String> out to filename in its entirety.  
 * You may assume we are using UTF 8.
 */
public class J_11 {

	/**
	 * main function that demonstrates that ReadTextFile and WriteTextFile 
	 * works
	 * @param args unused
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String filename;
		ArrayList<String> contents = new ArrayList<String>();

		char cont = 'y';
		char more_text = 'y';

		// input loop
		while (cont == 'y') {
			System.out.print("Enter a file name to write to: ");
			filename = input.nextLine();

			// secondary input loop for contents of file
			while (more_text == 'y') {
				System.out.print("Enter a line of text: ");
				contents.add(input.nextLine());
				System.out.print("Add another line to the file? (y/n): ");
				more_text = input.nextLine().charAt(0);
			}

			// write the file
			WriteTextFile(contents, filename);


			// read the file!
			System.out.print("Enter a file name to read from: ");
			filename = input.nextLine();

			contents = ReadTextFile(filename);

			// output the file!
			for (String line: contents) {
				System.out.println(line);
			}

			System.out.print("Again? (y/n): ");
			cont = input.nextLine().charAt(0);
		}
	}

	/**
	 * Code stolen from the instructor Coveny
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

	/**
	 * Code stolen from the instructor Coveny
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
