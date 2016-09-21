package ci245.extra.E1;

import java.util.Arrays;

public class E1 {
	public static void main(String[] args) {
		String[][] sudoku = new String[9][9];
		for (String[] row: sudoku) {
			Arrays.fill(row, "123456789");
		}
		assign(sudoku, 0, 5, "8");
		assign(sudoku, 0, 8, "4");
		
		assign(sudoku, 1, 5, "6");
		assign(sudoku, 1, 4, "1");
		assign(sudoku, 1, 2, "4");
		assign(sudoku, 1, 1, "8");
		
		assign(sudoku, 2, 6, "1");
		assign(sudoku, 2, 3, "5");

		assign(sudoku, 3, 6, "9");
		assign(sudoku, 3, 3, "8");
		assign(sudoku, 3, 2, "3");
		assign(sudoku, 3, 0, "1");

		assign(sudoku, 4, 0, "6");
		assign(sudoku, 4, 2, "8");
		assign(sudoku, 4, 6, "4");
		assign(sudoku, 4, 8, "3");

		assign(sudoku, 5, 8, "1");
		assign(sudoku, 5, 6, "5");
		assign(sudoku, 5, 5, "9");
		assign(sudoku, 5, 2, "2");
		
		assign(sudoku, 6, 5, "2");
		assign(sudoku, 6, 2, "7");

		assign(sudoku, 7, 7, "6");
		assign(sudoku, 7, 6, "2");
		assign(sudoku, 7, 4, "8");
		assign(sudoku, 7, 3, "7");

		assign(sudoku, 8, 3, "3");
		assign(sudoku, 8, 0, "2");
		
		print_sudoku(sudoku);
		
		solve(sudoku);
		
		print_sudoku(sudoku);

	}

	public static void print_sudoku(String[][] sudoku) {
		for (int i=0;i<9;i++) {
			if (i%3 == 0) {
				for (int j=0;j<9;j++ ) {
					System.out.print("----------");
				}
				System.out.println("---");
			}
			for (int j=0;j<9;j++ ) {
				if (j%3 == 0) {
					System.out.print("|");
				}
				System.out.printf("%10s", sudoku[i][j]);
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	public static boolean solve(String[][] sudoku) {
		String[][] sudoku_tmp = new String[9][9];
		int[] least;
		
	//	we've failed, return an empty array to show that
		if (!valid(sudoku)) {
			print_sudoku(sudoku);
			return false;
		}
	//	done! return the finished thing!
		else if (finished(sudoku)) {
			return true;
		}
	//	first we eliminate all the things we can
		else {
			print_sudoku(sudoku);
		//  not done? then we need to search for something more
		//  let's find the lowest amount of possibilities left in a box
		//	and then guess which one we should use, 
		//	and if we don't get a contradiction, then keep it!
			least = least_left(sudoku);

		//	go through all the possibilities, if one sticks then keep using it
			for (int k=0;k<least[0];k++) {
				sudoku_tmp = copy_board(sudoku);
				if (assign(sudoku_tmp, least[1], least[2], Character.toString(sudoku[least[1]][least[2]].charAt(k)))) {
					if (solve(sudoku_tmp)) {
						sudoku = copy_board(sudoku_tmp);
						break;
					}
				}
				else {
					return false;
				}
			}
			return solve(sudoku);
		}
	}
	
	/**
	 * find the first cell that has the smallest amount of possibilities left
	 * @param sudoku
	 * @return
	 */
	public static int[] least_left(String[][] sudoku) {
		int[] least = new int[3];
		least[0] = 9;
		// find first square that has the least number of possibilities
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				if (sudoku[i][j].length() < least[0] && sudoku[i][j].length() > 1) {
					least[0] = sudoku[i][j].length();
					least[1] = i;
					least[2] = j;
				}
			}
		}
		return least;
	}
	
	/**
	 * copy the board to a new variable
	 * @param board
	 * @return
	 */
	public static String[][] copy_board(String[][] board) {
		String[][] tmp = new String[9][9];
		
		for(int j=0;j<9;j++) {
			System.arraycopy(board[j], 0, tmp[j], 0, 9);
		}
		
		return tmp;
	}

	public static boolean assign(String[][] sudoku, int row, int col, String value) {
		sudoku[row][col] = value;
		if (sudoku[row][col].length() == 1) {
			eliminate(sudoku);
			print_sudoku(sudoku);
		}
		
		if (valid(sudoku)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @param sudoku
	 */
	public static boolean eliminate(String[][] sudoku) {
		int tmp_i;
		int tmp_j;
		boolean again = false;
		
	//	remove all the duplicates
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				if (sudoku[i][j].length() == 1) {
				//	isolate the box
					if (i < 3) {
						tmp_i = 0;
					}
					else if (i < 6) {
						tmp_i = 3;
					}
					else {
						tmp_i = 6;
					}
					
					if (j < 3) {
						tmp_j = 0;
					}
					else if (j < 6) {
						tmp_j = 3;
					}
					else {
						tmp_j = 6;
					}
					for (int ii=tmp_i;ii<(3 + tmp_i);ii++) {
						for (int jj=tmp_j;jj<(3+tmp_j);jj++) {
							if (ii != i || jj != j) {
								if (sudoku[ii][jj].length() == 2 && sudoku[ii][jj].replace(sudoku[i][j], "").length() == 1) {
									again = true;
								}
								sudoku[ii][jj] = sudoku[ii][jj].replace(sudoku[i][j], "");
								//if (sudoku[ii][jj].length() == 1) {
								//	assign(sudoku, ii, jj, sudoku[ii][jj].replace(sudoku[i][j], ""));
								//}
							}
						}
					}
					/**/
					for (int ii=0;ii<9;ii++) {
					//	isolate column
						if (ii != j) {
							if (sudoku[i][ii].length() == 2 && sudoku[i][ii].replace(sudoku[i][j], "").length() == 1) {
								again = true;
							}
							sudoku[i][ii] = sudoku[i][ii].replace(sudoku[i][j], "");
							//if (sudoku[i][ii].length() == 1) {
							//	assign(sudoku, i, ii, sudoku[i][ii].replace(sudoku[i][j], ""));
							//}
						}
					//	isolate row
						if (ii != i) {
							if (sudoku[ii][j].length() == 2 && sudoku[ii][j].replace(sudoku[i][j], "").length() == 1) {
								again = true;
							}
							sudoku[ii][j] =sudoku[ii][j].replace(sudoku[i][j], "");
							//if (sudoku[ii][j].length() == 1) {
							//	assign(sudoku, ii, j, sudoku[ii][j].replace(sudoku[i][j], ""));
							//}
						}
					}
					/**/
				}
			}
		}
		
		if (again) {
			eliminate(sudoku);
		}
		
		if (valid(sudoku)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * if the sudoku board finished?
	 * @param sudoku a sudoku board
	 * @return true if it's finished!
	 */
	public static boolean finished(String[][] sudoku) {
		boolean finished = true;
		
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				if (sudoku[i][j].length() > 1) {
					finished = false;
					break;
				}
			}
			if (!finished) {
				break;
			}
		}
		
		return finished;
	}
	
	/**
	 * validates a sudoku board
	 * @param sudoku a sudoku board
	 * @return if the board is valid or not
	 */
	public static boolean valid(String[][] sudoku) {
		boolean is_valid = true;
		
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				if (sudoku[i][j] == null) {
					is_valid = false;
					break;
				}
				else if (sudoku[i][j].length() == 0) {
					is_valid = false;
					break;
				}
				/*
				else if (sudoku[i][j].length() == 1) {
					for (int ii=0;ii<9;ii++) {
					//	isolate column
						if (ii != j && sudoku[ii][j].equals(sudoku[i][j])) {
							is_valid = false;
							break;
						}
					//	isolate row
						if (ii != i && sudoku[i][ii].equals(sudoku[i][ii])) {
							is_valid = false;
							break;
						}
					}
					if (!is_valid) {
						break;
					}
				}*/
			}
			if (!is_valid) {
				break;
			}
		}
		
		return is_valid;
	}
}
