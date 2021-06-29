import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    public static void main(String[] args) {

//        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
//        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
//        System.out.println(Arrays.deepToString(intervalIntersection(firstList, secondList)));


        int[][] firstList1 = {{3,10}};
        int[][] secondList1 = {{5,10}};
        System.out.println(Arrays.deepToString(intervalIntersection(firstList1, secondList1)));
        //23:06
        //11:35

    }


    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int j = 0;
        int i = 0;
        List<int[]> list = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {

            int[] currentFirst = firstList[i];
            int[] currentSecond = secondList[j];

            if (currentFirst[1] < currentSecond[0]) {
                i++;
            } else if (currentFirst[0] > currentSecond[1]) {
                j++;
            } else {
                int highBound = Math.min(currentFirst[1], currentSecond[1]);
                int lowBound = Math.max(currentFirst[0], currentSecond[0]);
                list.add(new int[]{lowBound, highBound});
                if (highBound < currentSecond[1]) {
                    i++;
                } else if (highBound < currentFirst[1]) {
                    j++;
                }else{
                    i++;
                    j++;
                }

            }

        }


        int[][] array = new int[list.size()][];
        return list.toArray(array);
    }
}
