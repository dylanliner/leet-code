import java.util.HashMap;
import java.util.Map;

public class TwoSumFaceBook {
    public static void main(String[] args) {

        System.out.println(numberOfWays(new int[]{1, 5, 3, 3, 3}, 6));
    }

    static int numberOfWays(int[] arr, int k) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : arr) {
            if (map.containsKey(k - i)) {
                count = count + map.get(k - i);
            }
            map.merge(i, 1, Integer::sum);
        }
        return count;

    }
}
