import java.util.Arrays;
import java.util.HashSet;

public class PassingYearbooks {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findSignatureCounts(new int[]{2, 1})));

    }

    static int[] findSignatureCounts(int[] arr) {

        int[] signatureCounts = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int nextStudent = arr[i] - 1;
            if (nextStudent < 0) {
                nextStudent = arr.length - 1;
            }
            recursion(nextStudent, 1, arr[i], arr, signatureCounts);
        }
        // Write your code here
        return signatureCounts;
    }

    private static void recursion(int currentStudent, int count, int initialStudent, int[] arr, int[] signatureCounts) {

        if (arr[currentStudent] == initialStudent) {
            signatureCounts[currentStudent] = count;
        } else {
            count++;
            int nextStudent = arr[currentStudent] - 1;
            if (nextStudent < 0) {
                nextStudent = arr.length - 1;
            }
            recursion(nextStudent, count, initialStudent, arr, signatureCounts);
        }
    }
}
