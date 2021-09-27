import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        //int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        eraseOverlapIntervals(intervals);
        //20:27
        System.out.println(eraseOverlapIntervals(intervals));
    }


    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        int inOrder = 1;

        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                inOrder++;
            }
        }

        return intervals.length - inOrder;

    }
}
