import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {

        int[] numbers = {0, 6, 4, 1, 0, 0, 7, 3, 0};
        int[] numbers2 = {2, 1};
        moveZeroes(numbers2);

        System.out.println(Arrays.toString(numbers2));
    }

    public static void moveZeroes(int[] nums) {

        int offset = 0;
        for (int i = 0; i < nums.length; i++) {

            nums[i - offset] = nums[i];
            if (nums[i] == 0) {
                offset++;
            }
            if (i >= offset && i != 0 && offset > 0) {
                nums[i] = 0;
            }

        }

    }
}
