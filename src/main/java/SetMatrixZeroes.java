import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
        int[][] matrix2 = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }

    public static void setZeroes(int[][] matrix) {

        List<Integer> colToSetToZero = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            boolean setRowToZero = false;
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    setRowToZero = true;
                    colToSetToZero.add(col);
                }
            }
            if (setRowToZero) {
                matrix[row] = new int[matrix[0].length];
            }
        }

        for (int col : colToSetToZero) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = 0;
            }
        }


    }
}
