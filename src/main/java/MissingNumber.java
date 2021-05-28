import java.util.HashSet;

public class MissingNumber {

    public static void main(String[] args) {

        int[] numbers = {9,6,4,2,3,5,7,0,1};

        System.out.println(missingNumber(numbers));

    }

    public static int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int output = 0;

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                output = i;
            }
        }
        return output;
    }
}
