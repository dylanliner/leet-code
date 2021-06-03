import java.util.Arrays;

public class ContiguousSubarrays {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(countSubarrays(new int[]{3, 4, 1, 6, 2})));
    }

    static int[] countSubarrays(int[] arr) {
        int[] ints = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            int indexVal = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] > indexVal) {
                    break;
                }
                count++;
            }
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > indexVal) {
                    break;
                }
                count++;
            }
            ints[i] =count;

        }
        return ints;
    }
}
