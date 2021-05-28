import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {

        int[] numbers = {4, 1, 2, 1, 2};

        System.out.println(singleNumber(numbers));

    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1 ; i = i + 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return nums[nums.length-1];
    }
}
