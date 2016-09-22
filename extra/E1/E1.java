//package ci245.extra.E1;

import java.util.Arrays;

public class E1 {
    /**
     * solves a sudoku problem!
     * @param args not used
     */
    public static void main(String[] args) {
        String[][] sudoku;
        sudoku = new String[][]{{"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},

                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},

                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""}
        };

        sudoku = new String[][]{{"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},

                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},

                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", ""}
        };

//      another easy problem
        sudoku = new String[][]{{"3", "", "7", "", "9", "", "", "1", ""},
                {"", "9", "1", "", "", "", "", "", "8"},
                {"5", "6", "", "", "", "1", "7", "", "9"},

                {"", "", "6", "3", "4", "", "", "", "1"},
                {"1", "", "3", "", "", "", "9", "", "5"},
                {"8", "", "", "5", "1", "", "6", "", ""},

                {"", "4", "", "1", "", "", "8", "", "7"},
                {"7", "", "", "", "", "", "3", "6", ""},
                {"6", "", "", "", "", "8", "", "5", "4"}
        };

        // easy
        sudoku = new String[][]{{"", "9", "", "", "", "2", "", "", "6"},
                {"6", "2", "3", "", "", "", "5", "8", ""},
                {"", "1", "", "7", "6", "", "", "", ""},

                {"7", "", "", "", "", "", "", "", ""},
                {"", "5", "9", "", "1", "", "4", "3", ""},
                {"", "", "", "", "", "", "", "", "5"},

                {"", "", "", "", "3", "6", "", "7", ""},
                {"", "7", "6", "", "", "", "1", "5", "4"},
                {"1", "", "", "5", "", "", "6", "", ""}
        };

        // easy
        sudoku = new String[][]{{"1", "", "", "", "", "6", "5", "", ""},
                {"", "", "7", "", "", "", "2", "", ""},
                {"", "6", "8", "", "", "", "", "4", "7"},

                {"", "1", "5", "8", "", "4", "9", "", "3"},
                {"6", "", "", "7", "", "5", "", "", "4"},
                {"8", "", "4", "3", "", "9", "6", "5", ""},

                {"9", "3", "", "", "", "", "4", "8", ""},
                {"", "", "2", "", "", "", "7", "", ""},
                {"", "", "6", "9", "", "", "", "", "1"}
        };

        // easy
        sudoku = new String[][]{{"1", "", "", "", "", "6", "5", "", ""},
                {"", "", "7", "", "", "", "2", "", ""},
                {"", "6", "8", "", "", "", "", "4", "7"},

                {"", "1", "5", "8", "", "4", "9", "", "3"},
                {"6", "", "", "7", "", "5", "", "", "4"},
                {"8", "", "4", "3", "", "9", "6", "5", ""},

                {"9", "3", "", "", "", "", "4", "8", ""},
                {"", "", "2", "", "", "", "7", "", ""},
                {"", "", "6", "9", "", "", "", "", "1"}
        };

        // hard
        sudoku = new String[][]{{"", "", "", "", "8", "", "", "9", ""},
                {"", "", "", "7", "3", "", "5", "8", ""},
                {"3", "9", "", "", "", "5", "", "", ""},

                {"", "1", "", "", "", "", "", "4", "2"},
                {"2", "", "", "", "6", "", "", "", "8"},
                {"6", "8", "", "", "", "", "", "5", ""},

                {"", "", "", "8", "", "", "", "6", "5"},
                {"", "5", "9", "", "2", "6", "", "", ""},
                {"", "3", "", "", "4", "", "", "", ""}
        };

        // evil
        sudoku = new String[][]{{"", "", "", "5", "1", "", "9", "", ""},
                {"5", "", "", "", "4", "", "6", "", "7"},
                {"", "4", "", "", "", "7", "", "", "5"},

                {"", "", "", "4", "", "", "", "", ""},
                {"", "3", "9", "", "", "", "7", "6", ""},
                {"", "", "", "", "", "2", "", "", ""},

                {"8", "", "", "7", "", "", "", "1", ""},
                {"6", "", "5", "", "2", "", "", "", "8"},
                {"", "", "2", "", "8", "9", "", "", ""}
        };

    //  prime the srray
        fill_blanks(sudoku);

    //  first pass
        eliminate(sudoku);

    //  now solve!
        solve(sudoku, 0);

    //  show the fruits of our labor!
        print_sudoku(sudoku);

    }

    /**
     * fills the blank spaces of the sudoku array with the numbers that we're missing
     * @param sudoku
     */
    public static void fill_blanks(String[][] sudoku) {
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                if (sudoku[i][j].length() == 0) {
                    sudoku[i][j] = "123456789";
                }
            }
        }
    }

    /**
     * prints the sudoku board in a formatted way
     * @param sudoku
     */
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

    /**
     * Solves the sudoku board recusively
     * @param sudoku
     * @param depth
     * @return true if the solution is valid, false if we've run into a contradiction
     */
    public static boolean solve(String[][] sudoku, int depth) {
        String[][] sudoku_tmp;
        int[] least;

    //	we've failed, return an empty array to show that
        if (!valid(sudoku)) {
            return false;
        }
        //	done! return the finished thing!
        else if (finished(sudoku)) {
            return true;
        }
        //	first we eliminate all the things we can
        else {
            //  not done? then we need to search for something more
            //  let's find the lowest amount of possibilities left in a box
            //	and then guess which one we should use,
            //	and if we don't get a contradiction, then keep it!
            least = least_left(sudoku);

            //	go through all the possibilities, if one sticks then keep using it
            for (int k=0;k<least[0];k++) {
                System.out.println(depth);
                print_sudoku(sudoku);
                sudoku_tmp = copy_board(sudoku);
                if (assign(sudoku_tmp, least[1], least[2], Character.toString(sudoku[least[1]][least[2]].charAt(k)))) {
                    if (solve(sudoku_tmp, depth + 1)){//[0][0] != null) {
                        update_board(sudoku_tmp, sudoku);
                        break;
                    }
                }
            //  we must have run into a contradiction!
                else {
                    return false;
                }
            }
            return solve(sudoku, depth + 1);
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

    /**
     * copies from one board to another for backtracking, because Java is pass by value, kind of
     * @param from
     * @param to
     */
    public static void update_board(String[][] from, String[][] to) {
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                to[i][j] = from[i][j];
            }
        }
    }

    /**
     * assigns a number to the specified sudoku board at the specified place
     * then eliminates the value from all the places where it can't be now
     * @param sudoku
     * @param row
     * @param col
     * @param value
     * @return true if valid, false if contradiction occurred
     */
    public static boolean assign(String[][] sudoku, int row, int col, String value) {
        sudoku[row][col] = value;

        if (row == 1 && col == 6) {
            print_sudoku(sudoku);
        }

        if (sudoku[row][col].length() == 1) {
            eliminate(sudoku);
            //print_sudoku(sudoku);
        }

        if (valid(sudoku)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * goes through the array and gets rid of the values that we know can't be there
     * @param sudoku
     * @return true if valid, false if contradiction occurred
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
                    tmp_i = getSection(i);

                    tmp_j = getSection(j);

                    for (int ii=tmp_i;ii<(3 + tmp_i);ii++) {
                        for (int jj=tmp_j;jj<(3+tmp_j);jj++) {
                            if (ii != i || jj != j) {
                                if (sudoku[ii][jj].length() == 2 && sudoku[ii][jj].replace(sudoku[i][j], "").length() == 1) {
                                    again = true;
                                }
                                sudoku[ii][jj] = sudoku[ii][jj].replace(sudoku[i][j], "");
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
                        }
                        //	isolate row
                        if (ii != i) {
                            if (sudoku[ii][j].length() == 2 && sudoku[ii][j].replace(sudoku[i][j], "").length() == 1) {
                                again = true;
                            }
                            sudoku[ii][j] =sudoku[ii][j].replace(sudoku[i][j], "");
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
            find_last(sudoku);

            return true;
        }
        else {
            return false;
        }
    }

    /**
     * this works in conjunction with the eliminate function
     * it goes through the array and finds rows and columns where that value is the last place where it can occur
     * in that row or column
     *
     * only updates if valid
     * @param sudoku
     */
    public static void find_last(String[][] sudoku) {
        int found_row_count;
        int found_row_index;
        int found_col_count;
        int found_col_index;

        String value;
        String[][] temp = copy_board(sudoku);
        for (int k=1;k<10;k++) {
            value = String.valueOf(k);
            found_row_index = 10;
            found_col_index = 10;
        //  for each row, find any hidden singles
            for (int i = 0; i < 9; i++) {
                found_row_count = 0;
                found_col_count = 0;
                for (int j = 0; j < 9; j++) {
                //  search rows
                    if (temp[i][j].length() > 1) {
                        if (sudoku[i][j].indexOf(value) >= 0) {
                            found_row_count++;
                            found_row_index = j;
                        }
                    }
                //  search cols
                    if (temp[j][i].length() > 1) {
                        if (temp[j][i].indexOf(value) >= 0) {
                            found_col_count++;
                            found_col_index = j;
                        }
                    }
                }
                if (found_row_count == 1) {
                    assign(temp, i, found_row_index, value);
                }
                if (found_col_count == 1) {
                    assign(temp, found_col_index, i, value);
                }
            }
        }
        if (valid(temp)) {
            update_board(temp, sudoku);
        }
    }

    /**
     * gets the starting index of a square based on the index given
     * @param i
     * @return starting value of the box
     */
    private static int getSection(int i) {
        int tmp_i;
        if (i < 3) {
            tmp_i = 0;
        }
        else if (i < 6) {
            tmp_i = 3;
        }
        else {
            tmp_i = 6;
        }
        return tmp_i;
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
            }
            if (!is_valid) {
                break;
            }
        }

        return is_valid;
    }
}
