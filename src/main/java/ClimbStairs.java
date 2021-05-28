public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(44));

    }

    public static int climbStairs(int n) {
        return dp(n, new int[n + 1]);
//        return recursion(n, 0);
    }

    private static int recursion(int current, int count) {
        if (current == 0) {
            count++;
        } else if (current > 0) {
            count = recursion(current - 1, count) + recursion(current - 2, count);
            ;
        }
        return count;
    }

    private static int dp(int n, int[] dp) {
        dp[1] = 2;
        dp[0] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
