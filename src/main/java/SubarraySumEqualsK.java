public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3};
        int[] numbers2 = {1,1,1};

        System.out.println(subarraySum(numbers, 3));
        System.out.println(subarraySum(numbers2, 2));
        //1:10
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;

    }
}
