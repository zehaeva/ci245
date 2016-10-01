import java.util.Scanner;

/**
 * This class will run your project. You are not allowed to modify anything
 * contained in this file. It will also time your project.
 * 
 * @author Jason A. Covey
 * 
 */
public class RunSeatingChart {

	/**
	 * Runs the Angry Cousins Project
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {

		// Create a new instance of the student's project
		SeatingChart sc = new SeatingChart();

		// Print out the student name's
		String[] names = sc.getStudentNames();
		if (names.length == 1) {
			System.out.println(names[0]);
		} else if (names.length == 2) {
			// added a '\n' to print statement per instructor mistake, you're welcome
			System.out.printf("%s and %s\n", names[0], names[1]);
		} else {
			System.out.println(
					"The student(s) forgot to put their name(s) on it");
		}

		// Get the name of the file from the user.
		String filename = "";
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your input filename: ");
		filename = in.next();

		// start the timer
		long starttime = System.currentTimeMillis();

		// validate the file format
		int validationResults = sc.ValidateInputFile(filename);
		switch (validationResults) {
		case 1:
			System.out.println("The file's first line is invalid.");
			break;
		case 2:
			System.out.println("The file's second line is invalid.");
			break;
		case 3:
			System.out.println("The file's third line or higher is invalid");
			break;
		case 4:
			System.out.println("The file does not exist or cannot be read");
		default:
			
			// Get and display the results.
			GuestTable[] results = sc.GetSeatingChart(filename);
			System.out.printf("You need %d tables.\n", results.length);
			
			for (int i = 0; i < results.length; i++) {
				System.out.printf(
						"Table %d: %s\n", i + 1, results[i].GetGuestList());
			}
		}

		// end the timer and display the time results
		long endtime = System.currentTimeMillis();
		System.out.printf(
				"The program ran in %d milliseconds.\n", endtime - starttime);
	}

}
