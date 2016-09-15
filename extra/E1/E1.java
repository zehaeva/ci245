import java.util.Arrays;

public class E1 {
	public static void main(String[] args) {
		int[][] sudoku = new int[9][9];
		for (int[] row: sudoku) {
			Arrays.fill(row, 0);
		}
		sudoku[0][6] = 8;
		sudoku[0][8] = 4;
		sudoku[1][5] = 6;
		sudoku[1][4] = 1;
		sudoku[1][2] = 4;
		sudoku[1][1] = 8;
		sudoku[2][6] = 1;
		sudoku[2][3] = 5;
		sudoku[3][6] = 9;
		sudoku[3][3] = 8;
		sudoku[3][2] = 3;
		sudoku[3][0] = 1;
		sudoku[4][0] = 6;
		sudoku[4][2] = 8;
		sudoku[4][6] = 4;
		sudoku[4][8] = 3;
		sudoku[5][8] = 1;
		sudoku[5][6] = 5;
		sudoku[5][5] = 9;
		sudoku[5][2] = 2;
		sudoku[6][5] = 2;
		sudoku[6][2] = 7;
		sudoku[7][7] = 6;
		sudoku[7][6] = 2;
		sudoku[7][4] = 8;
		sudoku[7][3] = 7;
		sudoku[8][3] = 3;
		sudoku[8][0] = 2;

		print_sudoku(sudoku);

		sudoku = solve(sudoku);

		System.out.println("\n\n");
		
		print_sudoku(sudoku);

	}

	public static void print_sudoku(int[][] sudoku) {
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++ ) {
				System.out.printf("%d\t", sudoku[i][j]);		
			}
			System.out.println();
		}
	}

	public static int[][] solve(int[][] sudoku) {
		int try_me;
		boolean found = false;
		int i=0;
		int j=0;

		if (correct(sudoku)) {
		//  find first unsolved /
			for (i=0;i<9;i++) {
				for (j=0;j<9;j++) {
					if (sudoku[i][j] == 0) {
						found = true;
						break;
					}
				}
				if (found) {
					break;
				}
			}
		//  try every number until it's correct
			try_me = 1;
			while (!filled(sudoku) && try_me < 10) {
				sudoku[i][j] = try_me;
			//  try to solve the puzzle
				sudoku = solve(sudoku);
				try_me++;
			}
		}

		return sudoku;
	}
	
	public static boolean filled(int[][] sudoku) {
		boolean finished = true;
		
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				if (sudoku[i][j] == 0) {
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

	public static boolean correct(int[][] sudoku) {
		boolean correct = true;
		boolean[] found_row = new boolean[10];
		boolean[] found_col = new boolean[10];
		
		for (int i=0;i<9 ;i++ ) {
			Arrays.fill(found_row, false);
			Arrays.fill(found_col, false);
		//  rows
			for (int j=0;j<9 ;j++ ) {
				if (sudoku[i][j] != 0 ) {
					if (!found_row[sudoku[i][j]]) {
						found_row[sudoku[i][j]] = true;
					}
					else {
						correct = false;
						break;
					}
				}
			}
		//	columns
			for (int j=0;j<9 ;j++ ) {
				if (sudoku[j][i] != 0) {
					if (!found_col[sudoku[j][i]]) {
						found_col[sudoku[j][i]] = true;
					}
					else {
						correct = false;
						break;
					}
				}
			}
		//  leave if it's not right
			if (!correct) {
				break;
			}
		}
		return correct;
	}
}
