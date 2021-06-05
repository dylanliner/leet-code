import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public static void main(String[] args) {

        System.out.println(permute(new int[]{1, 2, 3}));

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutationList = new ArrayList<>();

        addNumber(new HashSet<>(), nums, new ArrayList<>(), permutationList);

        return permutationList;
    }

    private static void addNumber(Set<Integer> set, int[] nums, List<Integer> list, List<List<Integer>> permutationList) {
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                Set<Integer> newset = new HashSet<>(set);
                List<Integer> newlist = new ArrayList<>(list);
                newlist.add(nums[i]);
                newset.add(nums[i]);
                if (newlist.size() < nums.length) {
                    addNumber(newset, nums, newlist, permutationList);
                } else {
                    permutationList.add(newlist);
                }
            }

        }
    }
}
