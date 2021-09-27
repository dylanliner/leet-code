import java.util.*;

public class OptimalUtilization {

    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
        int[][] b = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        //16:26/16:49
        optimalUtilization(a, b, 10).forEach(
                el->System.out.println(Arrays.toString(el))
        );
    }
//        11:45


    private static List<int[]> optimalUtilization(int[][] arr1, int[][] arr2, int target) {

        int distToTarget = Integer.MAX_VALUE;
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (target - (arr1[i][1] + arr2[j][1]) >= 0) {
                    if (distToTarget > target - (arr1[i][1] + arr2[j][1])) {
                        distToTarget = target - (arr1[i][1] + arr2[j][1]);
                        ans.clear();
                        ans.add(new int[]{arr1[i][0], arr2[j][0]});
                    } else if (distToTarget == target - (arr1[i][1] + arr2[j][1])) {
                        ans.add(new int[]{arr1[i][0], arr2[j][0]});
                    }
                }
            }
        }

        return ans;

    }
}
