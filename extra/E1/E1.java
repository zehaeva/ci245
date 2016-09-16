import java.util.Arrays;

public class E1 {
	public static void main(String[] args) {
		String[][] sudoku = new String[9][9];
		for (String[] row: sudoku) {
			Arrays.fill(row, "123456789");
		}
		sudoku[0][5] = "8";
		sudoku[0][8] = "4";
		sudoku[1][5] = "6";
		sudoku[1][4] = "1";
		sudoku[1][2] = "4";
		sudoku[1][1] = "8";
		sudoku[2][6] = "1";
		sudoku[2][3] = "5";
		sudoku[3][6] = "9";
		sudoku[3][3] = "8";
		sudoku[3][2] = "3";
		sudoku[3][0] = "1";
		sudoku[4][0] = "6";
		sudoku[4][2] = "8";
		sudoku[4][6] = "4";
		sudoku[4][8] = "3";
		sudoku[5][8] = "1";
		sudoku[5][6] = "5";
		sudoku[5][5] = "9";
		sudoku[5][2] = "2";
		sudoku[6][5] = "2";
		sudoku[6][2] = "7";
		sudoku[7][7] = "6";
		sudoku[7][6] = "2";
		sudoku[7][4] = "8";
		sudoku[7][3] = "7";
		sudoku[8][3] = "3";
		sudoku[8][0] = "2";

		print_sudoku(sudoku);

		sudoku = solve(sudoku, 1);
		
		print_sudoku(sudoku);

	}

	public static void print_sudoku(String[][] sudoku) {
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++ ) {
				if (sudoku[i][j].length() == 1) {
					System.out.printf("%10s", sudoku[i][j]);
				}
				else {
					//System.out.print("_\t");
					System.out.printf("%10s", sudoku[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	public static String[][] solve(String[][] sudoku, int try_me) {
		int tmp_i = 0;
		int tmp_j = 0;
		String[][] sudoku_tmp;
		
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
							if (ii != i && jj != j) {
								sudoku[ii][jj] = sudoku[ii][jj].replace(sudoku[i][j], "");
							}
						}
					}
					/**/
					for (int ii=0;ii<9;ii++) {
					//	isolate column
						if (ii != j) {
							sudoku[i][ii] = sudoku[i][ii].replace(sudoku[i][j], "");
						}
					//	isolate row
						if (ii != i) {
							sudoku[ii][j] = sudoku[ii][j].replace(sudoku[i][j], "");
						}
					}
					/**/
				}
			}
		}
		print_sudoku(sudoku);
		
	//  not done? do it again!
		if (!finished(sudoku)) {
			sudoku = solve(sudoku, try_me);
			
		// find first square that has two
			for (int i=0;i<9;i++) {
				for (int j=0;j<9;j++) {
					if (sudoku[i][j].length() == (try_me + 1)) {
						sudoku[i][j] = Character.toString(sudoku[i][j].charAt(0)); 
						sudoku_tmp = solve(sudoku, try_me + 1);
						if (!valid(sudoku_tmp)) {
							
						}
					}
				}
			}
			
		}

		return sudoku;
	}
	
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
	
	public static boolean valid(String[][] sudoku) {
		boolean is_valid = true;
		
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				if (sudoku[i][j].length() > 1) {
					for (int ii=0;ii<9;ii++) {
					//	isolate column
						if (ii != j && sudoku[ii][j].equals(sudoku[i][j])) {
							is_valid = false;
						}
					//	isolate row
						if (ii != i && sudoku[i][ii].equals(sudoku[i][ii])) {
							is_valid = false;
						}
					}
					if (!is_valid) {
						break;
					}
				}
			}
			if (!is_valid) {
				break;
			}
		}
		
		return is_valid;
	}
}
