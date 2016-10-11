import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This class determines the seating chart of a wedding such that no two people
 * who hate each other are sitting at the same table.
 * 
 * You may not add any public methods or fields to this class. You may not add
 * any static methods or fields to this class. You may not change the method
 * signature of any public method.  You may add any imports you like.
 * 
 * You may add as many private methods or fields as you want.
 * 
 * Please add your name and the name of your partner below as authors.
 * 
 * @author Jason A. Covey
 * 
 */
public class SeatingChart {

	/**
	 * This method should return an array with just your name or your name and
	 * your partner's name.
	 * 
	 * @return an array with your names
	 */
	public String[] getStudentNames() {
		// return new String[] { "One Person Working Alone" };
		// return new String[] { "First Partner", "Second Partner" };
		return new String[] {"Howard Canaway"};
	}

	/**
	 * This method should validate the input file as specified in the project
	 * instructions. You may also store your input file in a data structure if
	 * you wish.
	 * 
	 * @param filename
	 *            the user entered filename
	 * @return 1 if the first line is invalid, 2 if the second line is invalid,
	 *         3 if the third or a subsequent line is valid, 4 if the file
	 *         cannot be read or opened, and any other number otherwise.
	 */
	public int ValidateInputFile(String filename) {
		int code = 0;
		String[] temp;

		try {
			ArrayList<String> file_to_verify = ReadTextFile(filename);

			if (!file_to_verify.get(0).matches("^[0-9]+$")) {
				code = 1;
			}
			else if (Integer.parseInt(file_to_verify.get(0)) < 10 || Integer.parseInt(file_to_verify.get(0)) > 200) {
				code = 1;
			}
			else if (!file_to_verify.get(1).equals("5") &&
					 !file_to_verify.get(1).equals("6") &&
					 !file_to_verify.get(1).equals("7") &&
					 !file_to_verify.get(1).equals("8") &&
					 !file_to_verify.get(1).equals("100000")) {
				code = 2;
			} else {
				for (int i = 2; i < file_to_verify.size() - 1; i++) {
					if (!file_to_verify.get(i).matches("^[0-9]+ [0-9]+$")) {
						code = 3;
						break;
					}
					else {
						temp = file_to_verify.get(i).split(" ");
						if ((Integer.parseInt(temp[0]) < 1 || Integer.parseInt(temp[0]) > 200) ||
								(Integer.parseInt(temp[1]) < 1 || Integer.parseInt(temp[1]) > 200) ) {
							code = 3;
							break;
						}
					}
				}
			}

		}
		catch (IOException e) {
			code = 4;
		}

		return code;
	}// end ValidateInputFile

	/**
	 * Code stolen from the instructor Coveny J_11
	 * @param fileName the name of the file to read
	 * @return arraylist of the file
	 */
	private ArrayList<String> ReadTextFile(String fileName) throws IOException {
		// Now we will read all of the lines back that we just wrote
		Path path = Paths.get(fileName);
		ArrayList<String> linesToRead = new ArrayList<String>();

		try {
			// Need to cast the return result to an ArrayList
			linesToRead = (ArrayList<String>) Files.readAllLines(path, StandardCharsets.UTF_8);

		} catch (IOException e) {
			throw e;
		}

		return linesToRead;
	}

	/**
	 * This method should determine the seating chart for the wedding as
	 * specified in the project instructions. The filename is given if you chose
	 * not to store your input file in a data structure during validation.
	 * 
	 * @param filename
	 *            the user entered filename
	 * @return the array of tables that seat the guests so that no two guests
	 *         who hate each other are sitting at the same table.
	 */
	public GuestTable[] GetSeatingChart(String filename) {
		return new GuestTable[] { };
	}
}
