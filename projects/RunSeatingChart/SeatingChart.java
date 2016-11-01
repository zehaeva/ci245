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
	private ArrayList<Integer> _table_head_count;

	private ArrayList<String> _file_to_verify;
	private String _file_name_to_verify;

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
		int guest_one;
		int guest_two;
		//long starttime = System.currentTimeMillis();

		try {
			_file_name_to_verify = filename;
			_file_to_verify = ReadTextFile(filename);

			this._num_guests = Integer.parseInt(_file_to_verify.get(0));
			this._hate_list = new boolean[this._num_guests + 1][this._num_guests + 1];
		//  let's assume that no one hates each other
			for (boolean[] btemp :
					this._hate_list) {
				Arrays.fill(btemp, false);
			}

			if (this._num_guests < 10 && this._num_guests > 200) {
				code = 1;
			}
			else if (!_file_to_verify.get(1).equals("5") &&
					 !_file_to_verify.get(1).equals("6") &&
					 !_file_to_verify.get(1).equals("7") &&
					 !_file_to_verify.get(1).equals("8") &&
					 !_file_to_verify.get(1).equals("100000")) {
				code = 2;
			} else {
				max_guests = Integer.parseInt(_file_to_verify.get(0));

				for (int i = 2; i < _file_to_verify.size() - 1; i++) {
					temp = _file_to_verify.get(i).split(" ");
					if (temp.length != 2) {
						code = 3;
						break;
					} else {
						try {
							guest_one = Integer.parseInt(temp[0]);
							guest_two = Integer.parseInt(temp[1]);
							if ((guest_one < 0 || guest_one > max_guests) || (guest_two < 0 || guest_two > max_guests)) {
								code = 3;
								System.out.println(i);
								break;
							}
							//	memoize!
							this._hate_list[guest_one][guest_two] = true;
							this._hate_list[guest_two][guest_one] = true;
						}
						catch (NumberFormatException e) {
							code = 3;
							break;
						}
					}
				}
			}

		}
		catch (NumberFormatException e) {
			code = 1;
		}
		catch (IOException e) {
			code = 4;
		}
		//long endtime = System.currentTimeMillis();
		//System.out.printf("The File Validated in %d milliseconds.\n", endtime - starttime);

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
        ArrayList<String> file;
		GuestTable[] gt;

		//long starttime = System.currentTimeMillis();

		try {
			if (filename.equals(_file_name_to_verify)) {
				file = _file_to_verify;
			} else {
				file = ReadTextFile(filename);
			}

		//	initialize the arrays!
			this._num_guests = Integer.parseInt(file.get(0));
			this._table_size = Integer.parseInt(file.get(1));
			this._hate_sort = new int[this._num_guests];
			this._tables = new int[this._num_guests];

			this._table_head_count = new ArrayList<>();
			this._table_head_count.add(0);

			Arrays.fill(this._tables, 0);

		//	seat the guests at a table!
			seat_guest(get_next_guest(this._tables));
		}
		catch (IOException e) {
			System.out.println("Something went wrong reading the file!");
		}
		finally {
		//	setup for returning C:\Users\hcanaway.CFS\IdeaProjects\ci245\projects\RunSeatingChart\random_file.txt
		//	how many tables did we use?
			int max_table = 0;
			for (int i = 0; i < this._tables.length; i++) {
				if (max_table < this._tables[i]) {
					max_table = this._tables[i];
				}
			}

			gt = new GuestTable[max_table];
			for (int i = 0; i < max_table; i++) {
				gt[i] = new GuestTable();
			}

			for (int i = 0; i < this._tables.length; i++) {
				gt[this._tables[i] - 1].AddGuestToTable(i);
			}
		}

		//long endtime = System.currentTimeMillis();
		//System.out.printf("The program ran in %d milliseconds.\n", endtime - starttime);

        return gt;
	}

	/**
	 * Seats the numbered guest at a table
	 * @param next_guest Guest to be sat
	 * @return True if we're finished, false if we're not
	 */
	private boolean seat_guest(int next_guest) {
	//	is there a conflict?
		if (!no_conflicts(this._tables)) {
			return false;
	//	are we done?
		} else if (everyone_seated(this._tables)) {
			return true;
	//	find a seat for this guest
		} else {
			int table = 1;
			do {
			//	make sure the table isn't full already
				while (table_full(this._tables, table)) {
					table++;
				}
				//	set guest at this table
				this._tables[next_guest] = table;

				this._table_head_count.set(table, this._table_head_count.get(table) + 1);
				//seat the next guest!
				if (!seat_guest(get_next_guest(this._tables))) {
				//	oh no! this guest can't go here, let's put him at the next table
					this._table_head_count.set(table, this._table_head_count.get(table) - 1);
					table++;
					this._tables[next_guest] = 0;
				}
			} while (!everyone_seated(this._tables));

			return true;
		}
	}

	/**
	 * checks to see that people at the same tables don't hate eachother
	 * @param assigned_seats
	 * @return
	 */
	private boolean no_conflicts(int[] assigned_seats) {
		boolean valid = true;
		for (int i = 0; i < assigned_seats.length; i++) {
		//	has someone been assigned?
			if (assigned_seats[i] > 0) {
			//	check all other people at this table, do they hate this person?
				for (int j = 0; j < assigned_seats.length; j++) {
				//	are these people at the same table?
					if (i != j && assigned_seats[j] == assigned_seats[i]) {
					//	do they hate each other?
						if (this._hate_list[i][j]) {
						//	well damn, I guess we can't sit them together
							valid = false;
							break;
						}
					}
				}
			}
		//	stop if we've found an invalid table
			if (!valid) {
				break;
			}
		}

		return valid;
	}

	/**
	 * finds the next guest who hasn't been sat
	 * @param assigned_seats
	 * @return
	 */
	private int get_next_guest(int[] assigned_seats) {
		int temp = 0;
		for (int i = 0; i < assigned_seats.length; i++) {
			if (assigned_seats[i] == 0) {
				temp = i;
			}
		}
		return temp;
	}

	/**
	 * checks to see if everyone has been sat
	 * @param assigned_seats
	 * @return
	 */
	private boolean everyone_seated(int[] assigned_seats) {
		boolean done = true;

		for (int value :
				assigned_seats) {
			if (value == 0) {
				done = false;
				break;
			}
		}

		return done;
	}

	/**
	 * checks the seating chart to see if the provided table is full
	 * @param assigned_seats
	 * @param table_num
	 * @return
	 */
	private boolean table_full(int[] assigned_seats, int table_num) {
		int count = 0;

		if (this._table_head_count.size() <= table_num) {
			this._table_head_count.add(table_num, 0);
		}

		count = this._table_head_count.get(table_num);

		if (count >= this._table_size) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * sorts the guests into a list of who hate the most to who hates the least
	 */
    private void sort_guests() {
        int temp_i;
		int temp_j;
    //  seed the sort
        for (int i = 0; i < this._num_guests; i++) {
            this._hate_sort[i] = i;
        }

    //  now we iterate over the sort
    //  and find if this person hates less than someone else
    //  then we swap
        for (int i = 0; i < this._num_guests; i++) {
            for (int j = 0; j < this._num_guests; j++) {
                if (this._hate_radix[i] < this._hate_radix[j]) {
					temp_i = getSortGuest(i);
					temp_j = getSortGuest(j);
					if (temp_i < temp_j) {
						this._hate_sort[temp_i] = j;
						this._hate_sort[temp_j] = i;
					}
				}
            }
        }
    }

	/**
	 * get the guest at the ith sort place
	 * @param i guest number
	 * @return
	 */
	private int getSortGuest(int i) {
		int temp_i = 0;
		for (int k = 0; k < this._num_guests; k++) {
            if (this._hate_sort[k] == i) {
                temp_i = k;
                break;
            }
        }
		return temp_i;
	}

	/**
	 * print an integer array
	 * @param array
	 * @param header
	 */
	private void print_array(int[] array, String header) {
		System.out.println(header);
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d: %d\n", i, array[i]);
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

	//	array initialization
        this._hate_list = new boolean[this._num_guests + 1][this._num_guests + 1];
        //this._hate_radix = new int[this._num_guests + 1];

    //  let's assume that no one hates each other
        for (boolean[] temp :
                this._hate_list) {
            Arrays.fill(temp, false);
        }
        //Arrays.fill(this._hate_radix, 0);

	//	go through the file, and build up the hate_list lookup table
	//	and build up the radix which counts how many people each guest hates
        for (int i = 2; i < file.size() - 1; i++) {
            edge = file.get(i).split(" ");
            hate_one = Integer.parseInt(edge[0]);
            hate_two = Integer.parseInt(edge[1]);
            this._hate_list[hate_one][hate_two] = true;
            this._hate_list[hate_two][hate_one] = true;
            //this._hate_radix[hate_one]++;
            //this._hate_radix[hate_two]++;
        }
    }
}
