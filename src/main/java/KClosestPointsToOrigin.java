import java.util.*;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {

        //int[][] points = {{1, 3}, {-2, 2}};
        // k = 1;

        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        System.out.println(Arrays.deepToString(kClosest(points, k)));
        //00:45


    }

    public static int[][] kClosest(int[][] points, int k) {


        SortedMap<Integer, List<int[]>> map = new TreeMap();
        for (int i = 0; i < points.length; i++) {
            map.computeIfAbsent(points[i][1] * points[i][1] + points[i][0] * points[i][0], x -> new ArrayList<>()).add(points[i]
            );
        }


        List<int[]> minIndices = new ArrayList<>();
        for (int d : map.keySet()) {

            minIndices.addAll(map.get(d));
        }


        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            ans[i] = minIndices.get(i);
        }

        return ans;

    }
}
