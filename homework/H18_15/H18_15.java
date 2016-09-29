public class H18_15 {
  public static void main(String[] args) {
	// write your code here
        boolean[][] board = new boolean[8][8];

        for (boolean[] col :
                board) {
            Arrays.fill(col, false);
        }

        board = place_queen(board, 0, 0);

        print_board(board);
    }

    private static void print_board(boolean[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j]) {
                    System.out.printf("* ");
                }
                else {
                    System.out.printf("_ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean[][] place_queen(boolean[][] board, int row, int col) {
        boolean[][] temp;

        board[row][col] = true;

        if (finished(board)) {
            return board;
        }
        else if (!valid(board)) {
            return new boolean[1][1];
        }
        else {
            while (row < 8 && col < 8) {
                // System.out.printf("Count: %d, row: %d, col: %d\n", queen_count(board), row, col);
                if (row == 7) {
                    row = 0;
                    col++;
                } else {
                    row++;
                }

                temp = copy_board(board);

                temp = place_queen(temp, row, col); //copy_board(board);

                //  place a queen there
                if (valid(temp)) {
                    return temp;
                }
            }
            return new boolean[1][1];
        }
    }

    private static boolean[][] copy_board(boolean[][] board) {
        boolean[][] temp = new boolean[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                temp[i][j] = board[i][j];
            }
        }

        return temp;
    }

    private static boolean valid(boolean[][] board) {
        boolean am_i_valid = true;

        if (board.length == 8) {

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j]) {
                        for (int k = 0; k < 8; k++) {
                            //  check row
                            if (i != k && board[i][k]) {
                                am_i_valid = false;
                            }
                            //  check col
                            if (j != k && board[k][j]) {
                                am_i_valid = false;
                            }

                            if (!am_i_valid) {
                                break;
                            }
                        }
                    }
                    if (!am_i_valid) {
                        break;
                    }
                }
                if (!am_i_valid) {
                    break;
                }
            }
        }
        else {
            am_i_valid =  false;
        }
        return am_i_valid;
    }

    public static int queen_count(boolean[][] board) {
        int count = 0;

        for (int i = 0; i <8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j]) {
                    count ++;
                }
            }
        }
        return count;
    }

    public static boolean finished(boolean[][] board) {
        if (queen_count(board) == 8) {
            return true;
        }
        else {
            return false;
        }
    }
}
