import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] matrix1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(matrix1));
        System.out.println(Arrays.toString(matrix1));
    }

    public static int removeDuplicates(int[] nums) {


        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int j = 0;
        int offset=0;
        for (int i = 0; i < nums.length; i++) {

            if (!set.add(nums[i])) {
                offset++;
                len--;
            } else {
                nums[j] = nums[j + offset];
                j++;

            }
        }
        return len;

    }
}
