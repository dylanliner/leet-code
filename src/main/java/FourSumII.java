import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FourSumII {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2, -1};
        int[] nums3 = new int[]{-1, 2};
        int[] nums4 = new int[]{0, 2};


        int[] nums5 = new int[]{0, 1, -1};
        int[] nums6 = new int[]{-1, 1, 0};
        int[] nums7 = new int[]{0, 0, 1};
        int[] nums8 = new int[]{-1, 1, 1};

        System.out.println(fourSumCount(nums5, nums6, nums7, nums8));
        //15/17 15:39

    }


    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int countWays = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int k = 0; k < nums3.length; k++) {
            for (int l = 0; l < nums4.length; l++) {
                map.merge(nums4[l] + nums3[k], 1, Integer::sum);
            }
        }


        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (map.containsKey(-(nums1[i] + nums2[j]))) {
                    countWays = countWays + map.get(-(nums1[i] + nums2[j]));
                }

            }


        }
        return countWays;

    }
}
