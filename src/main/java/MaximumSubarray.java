import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumSubarray {

    public static void main(String[] args) {


//        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(fasterMaxSumArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(fasterMaxSumArray(new int[]{1}));
        System.out.println(fasterMaxSumArray(new int[]{-2, 1}));

    }


    public static int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currentSum = nums[i];
            if (currentSum > max) {
                max = currentSum;
            }
            for (int j = i + 1; j < nums.length; j++) {

                currentSum += nums[j];

                if (currentSum > max) {
                    max = currentSum;
                }
            }

        }

        return max;
    }

    public static int fasterMaxSumArray(int[] nums) {

        int maxGlobal = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
             maxSoFar = Math.max(nums[i],maxSoFar+nums[i]);
             maxGlobal=Math.max(maxGlobal,maxSoFar);


        }

        return maxGlobal;
    }
}
