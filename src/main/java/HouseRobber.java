import java.util.*;

public class HouseRobber {

    public static void main(String[] args) {
//        System.out.println(rob(new int[]{1, 2, 3, 1}));
//        System.out.println(rob(new int[]{2,7,9,3,1}));
//        System.out.println(rob(new int[]{1, 1, 15, 30,10,1,10,1,1}));
//        System.out.println(rob(new int[]{2, 1, 3, 1, 1, 1, 1, 1, 1, 3, 1, 2}));
        System.out.println(robDP(new int[]{1, 2, 3, 1}));
        System.out.println(robDP(new int[]{2, 1, 1, 2}));
    }


    public static int robDP(int[] nums) {

        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);


    }

}
