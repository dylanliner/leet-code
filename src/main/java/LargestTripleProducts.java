import java.util.*;

public class LargestTripleProducts {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(findMaxProduct(new int[]{1, 2, 3, 4, 5})));

    }

    static int[] findMaxProduct(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();
        int[] ans = new int[arr.length];
        ans[0] = -1;
        ans[1] = -1;
        ans[2] = arr[0] * arr[1] * arr[2];
        list.add(arr[0]);
        list.add(arr[1]);
        list.add(arr[2]);

        for (int i = 3; i < arr.length; i++) {
            if (arr[i] > list.get(0)) {
                list.remove(0);
                list.add(arr[i]);
            }
            Collections.sort(list);
            ans[i] = list.stream().reduce(1, (a, b) -> a * b);
        }

        // Write your code here
        return ans;
    }
}
