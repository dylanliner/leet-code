import java.util.ArrayList;

public class TargetSum {

    public static void main(String[] args) {

        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {

        int count = 0;
        ArrayList<Integer> sums = new ArrayList<>();
        return sum(nums, target, 0, 0, count);
    }

    private static int sum(int[] nums, int target, int i, int sum, int count) {

        if (i < nums.length) {

            count = sum(nums, target, i + 1, sum + nums[i], count);
            count = sum(nums, target, i + 1, sum - nums[i],  count);
        } else if (sum == target) {
            return count + 1;
        } else {
            return count;
        }

        return count;
    }
}
