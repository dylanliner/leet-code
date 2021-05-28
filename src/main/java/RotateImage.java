import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
        int[][] matrix2 = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }

    public static void rotate(int[][] matrix) {


        for (int row = 0; row < matrix.length / 2; row++) {
            for (int col = row; col < matrix[0].length - 1 - row; col++) {

                int temp = matrix[row][col];
                rotate(temp, row, col, matrix, row, col);
            }
        }


    }

    public static void rotate(int temp, int row, int col, int[][] matrix, int stopAtRow, int stopAtCol) {

        int newRow = computeRow(row, col, matrix);
        int newCol = computeCol(row, col, matrix);
        int newTemp = matrix[newRow][newCol];
        matrix[newRow][newCol] = temp;
        if (newRow != stopAtRow || newCol != stopAtCol) {
            rotate(newTemp, newRow, newCol, matrix, stopAtRow, stopAtCol);
        }

    }

    private static int computeRow(int row, int col, int[][] matrix) {
        row = col;
        return row;
    }

    private static int computeCol(int row, int col, int[][] matrix) {
        col = matrix[0].length - 1 - row;
        return col;
    }


}
