import java.util.Arrays;
import java.util.HashMap;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));


    }

    public static int lengthOfLIS(int[] nums) {

        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] < current) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }

                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

}
