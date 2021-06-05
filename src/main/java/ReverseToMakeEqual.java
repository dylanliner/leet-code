import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReverseToMakeEqual {

    public static void main(String[] args) {

        System.out.println(areTheyEqual(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3, 3}));

    }

    static boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        if (array_a.length != array_b.length) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array_a.length; i++) {
            map.merge(array_a[i], 1, Integer::sum);
        }

        for (int i = 0; i < array_a.length; i++) {
            if (!map.containsKey(array_b[i])) {
                return false;
            }
            map.merge(array_b[i], -1, Integer::sum);
            if (map.get(array_b[i]) == 0) {
                map.remove(array_b[i]);
            }
        }
        return true;
    }

}
