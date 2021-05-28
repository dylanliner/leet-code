import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[]{-1};
        rotate(arr2, 2);
        System.out.println(Arrays.toString(arr2));

    }

    public static void rotate(int[] nums, int k) {
        int[] newArr = new int[nums.length];

        k = k % nums.length;

        for (int i = 0; i < nums.length; i++) {

            if (i + k < nums.length) {
                newArr[i + k] = nums[i];
            } else {
                newArr[k - (nums.length - i)] = nums[i];
            }


        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArr[i];
        }


    }

    public static void rotateRecursion(int[] nums, int k, int index, int value, int stopIndex, int count) {


        nums[index] = value;
        if (index == stopIndex) {
        }

    }
}
