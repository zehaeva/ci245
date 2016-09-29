public class H18_15 {
  public static void main(String[] args) {
	// write your code here
        boolean[][] board = new boolean[8][8];

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
    }

    public static boolean[][] place_queen(boolean[][] board, int row, int col) {
        return board;
    }
}
