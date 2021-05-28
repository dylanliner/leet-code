import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i==j){
                    continue;
                }
                int k = -nums[i] - nums[j];
                if (map.containsKey(k) && i != map.get(k) && j != map.get(k)) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], k);
                    Collections.sort(list);
                    set.add(list);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
