import java.util.Arrays;

public class E1 {
	public static void main(String[] args) {
		int[][] sudoku = new int[9][9];
		Arrays.fill(sudoku, 0);
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

		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++ ) {
				System.out.printf("%d\t", sudoku[i][j]);		
			}
			System.out.println();
		}
	}

	public static int[][] solve(int[][] sudoku) {

		if (!solved(sudoku)) {
			
		}

		return sudoku;
	}

	public static boolean solved(int[][] sudoku) {
		return false;
	}
}
