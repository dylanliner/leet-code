import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimizeMemoryUsage {

    public static void main(String[] args) {
        int[] a = {1, 7, 2, 4, 5, 6};
        int[] b = {3, 1, 2};
        //22:07 //22:23
        optimizeMemoryUsage(a, b, 6).forEach(
                el -> System.out.println(Arrays.toString(el))
        );
    }
//        11:45


    private static List<int[]> optimizeMemoryUsage(int[] arr1, int[] arr2, int memorySpace) {

        int minDist = Integer.MAX_VALUE;
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (memorySpace - arr1[i] < minDist) {
                ans.clear();
                ans.add(new int[]{arr1[i], -1});
            } else if (memorySpace - arr1[i] == minDist) {
                ans.add(new int[]{arr1[i], -1});
            }
            for (int j = 0; j < arr2.length; j++) {
                if (memorySpace - arr2[j] < minDist) {
                    ans.clear();
                    ans.add(new int[]{-1, arr2[j]});
                } else if (memorySpace - arr2[j] == minDist) {
                    ans.add(new int[]{-1, arr2[j]});
                }
                if (memorySpace - (arr1[i] + arr2[j]) >= 0) {


                    if (memorySpace - (arr1[i] + arr2[j]) < minDist) {
                        ans.clear();
                        ans.add(new int[]{arr1[i], arr2[j]});
                        minDist = memorySpace - (arr1[i] + arr2[j]);
                    } else if (memorySpace - (arr1[i] + arr2[j]) == minDist) {
                        ans.add(new int[]{arr1[i], arr2[j]});
                    }
                }
            }

        }

        return ans;

    }
}
