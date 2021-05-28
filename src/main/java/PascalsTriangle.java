import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {

        System.out.println(generate(5));

    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> output = new ArrayList();

        for (int row = 0; row < numRows; row++) {
            output.add(new ArrayList<>());
            for (int column = 0; column <= row; column++) {
                int num = 0;
                if (column == 0 || column == row) {
                    num = 1;
                } else {
                    num += output.get(row - 1).get(column - 1) + output.get(row - 1).get(column);
                }

                output.get(row).add(num);


            }

        }
        return output;
    }

}
