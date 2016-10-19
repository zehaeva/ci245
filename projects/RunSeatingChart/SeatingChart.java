import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

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
    private int _num_guests;
    private int _table_size;
    private boolean[][] _hate_list;
    private int[] _hate_radix;
    private int[] _hate_sort;
	private int[] _tables;

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
		int max_guests = 200;
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
				max_guests = Integer.parseInt(file_to_verify.get(0));

				for (int i = 2; i < file_to_verify.size() - 1; i++) {
					if (!file_to_verify.get(i).matches("^[0-9]+ [0-9]+$")) {
						code = 3;
						break;
					}
					else {
						temp = file_to_verify.get(i).split(" ");
						if (temp.length != 2) {
							code = 3;
                            break;
						}
						else if ((Integer.parseInt(temp[0]) < 1 || Integer.parseInt(temp[0]) > max_guests) ||
								(Integer.parseInt(temp[1]) < 1 || Integer.parseInt(temp[1]) > max_guests) ) {
							code = 3;
                            System.out.println(i);
							break;
						}
					}
				}
			}

		}
		catch (IOException e) {
            System.out.println(e.toString());
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
		Path path = Paths.get("/home/zehaeva/IdeaProjects/ci245/projects/RunSeatingChart/" + fileName);
		ArrayList<String> linesToRead = new ArrayList<String>();

		try {
			// Need to cast the return result to an ArrayList
			linesToRead = (ArrayList<String>) Files.readAllLines(path, StandardCharsets.UTF_8);

		} catch (IOException e) {
            System.out.println(path.toString());
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
        ArrayList<String> file = new ArrayList<>();

        try {
            file = ReadTextFile(filename);
        }
        catch (IOException e) {
            System.out.println("Something went wrong reading the file!");
        }

        this._num_guests = Integer.parseInt(file.get(0));
        this._table_size = Integer.parseInt(file.get(1));
		this._hate_sort = new int[this._num_guests];

        fill_hate_list(file);

		sort_guests();

		//seat_guest(this._hate_sort);

        for (int i = 0; i < this._num_guests; i++) {
            System.out.println(this._hate_sort[i]);
        }

        return new GuestTable[] { };
	}

    private void sort_guests() {
        int temp;
    //  seed the sort
        for (int i = 0; i < this._num_guests; i++) {
            this._hate_sort[i] = i + 1;
        }
    //  now we iterate over the sort
    //  and find if this person hates less than someone else
    //  then we swap
        for (int i = 0; i < this._num_guests; i++) {
            for (int j = 0; j < this._num_guests; j++) {
                if (this._hate_radix[this._hate_sort[i]] < this._hate_radix[j]) {
                    temp = this._hate_sort[i];
                    this._hate_sort[i] = j;
                    this._hate_sort[j] = temp;
                }
            }
        }
    }

    /**
     * fills the list full of hatred for one's kin
     * @param file
     */
    private void fill_hate_list(ArrayList<String> file) {
        String[] edge;
        int hate_one;
        int hate_two;

        this._hate_list = new boolean[this._num_guests + 1][this._num_guests + 1];
        this._hate_radix = new int[this._num_guests + 1];

    //  let's assume that no one hates each other
        for (boolean[] temp :
                this._hate_list) {
            Arrays.fill(temp, false);
        }
        Arrays.fill(this._hate_radix, 0);

        for (int i = 2; i < file.size() - 1; i++) {
            edge = file.get(i).split(" ");
            hate_one = Integer.parseInt(edge[0]);
            hate_two = Integer.parseInt(edge[1]);
            this._hate_list[hate_one][hate_two] = true;
            this._hate_list[hate_two][hate_one] = true;
            this._hate_radix[hate_one]++;
            this._hate_radix[hate_two]++;
        }
    }

    private void sort_hate() {
        for (int i = 0; i < this._num_guests; i++) {

        }
    }

    private void print_hate_counts() {
        for (int i = 1; i < this._num_guests; i++) {
            System.out.printf("%d: %d\n", (i), this._hate_radix[i]);
        }
    }
}
