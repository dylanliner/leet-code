public class ValidSudoku {
    public static void main(String[] args) {

        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));

        char[][] board2 = new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board2));

    }

    public static boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            if (!checkRow(row, board)) {
                return false;
            }
            ;
        }
        for (int column = 0; column < board.length; column++) {
            if (!checkColumn(column, board)) {
                return false;
            }
            ;
        }

        for (int r = 0; r < board.length; r = r + 3) {
            for (int c = 0; c < board.length; c = c + 3) {
                if (!check3X3Grid(r, c, board)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkColumn(int column, char[][] board) {
        int[] arr = new int[9];
        for (int row = 0; row < board.length; row++) {
            if (board[row][column] != '.') {
                if (arr[Character.getNumericValue(board[row][column]) - 1] > 0) {
                    return false;
                }
                arr[Character.getNumericValue(board[row][column]) - 1] = 1;
            }
        }

        return true;
    }

    private static boolean checkRow(int row, char[][] board) {
        int[] arr = new int[9];
        for (int column = 0; column < board.length; column++) {
            if (board[row][column] != '.') {
                if (arr[Character.getNumericValue(board[row][column]) - 1] > 0) {
                    return false;
                }
                arr[Character.getNumericValue(board[row][column]) - 1] = 1;
            }
        }
        return true;
    }

    private static boolean check3X3Grid(int row, int column, char[][] board) {

        int[] arr = new int[9];
        int startRow = getStartRow(row);
        int startColumn = getStartColumn(column);
        int endRow = getEndRow(row);
        int endColumn = getEndColumn(column);

        for (int r = startRow; r < endRow; r++) {
            for (int c = startColumn; c < endColumn; c++) {
                if (board[r][c] != '.') {
                    if (arr[Character.getNumericValue(board[r][c]) - 1] > 0) {
                        return false;
                    }
                    arr[Character.getNumericValue(board[r][c]) - 1] = 1;
                }
            }
        }

        return true;
    }

    private static int getEndColumn(int column) {
        if (column < 3) {
            return 3;
        }
        if (column < 6) {
            return 6;
        }
        return 9;
    }

    private static int getEndRow(int row) {
        if (row < 3) {
            return 3;
        }
        if (row < 6) {
            return 6;
        }
        return 9;
    }

    private static int getStartColumn(int column) {
        if (column < 3) {
            return 0;
        }
        if (column < 6) {
            return 3;
        }
        return 6;
    }

    private static int getStartRow(int row) {
        if (row < 3) {
            return 0;
        }
        if (row < 6) {
            return 3;
        }
        return 6;
    }

}
