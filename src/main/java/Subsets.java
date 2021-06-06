import java.util.*;

public class Subsets {

    public static void main(String[] args) {

        System.out.println(subsetsFast(new int[]{1, 2, 3,}));

    }

    public static List<List<Integer>> subsets(int[] nums) {

        Set<Set<Integer>> subsets = new HashSet<>();
        subsets.add(new HashSet<>());
        Set<Integer> set = new HashSet<>();
        addToList(subsets, set, nums);

        List<List<Integer>> lists = new ArrayList<>();
        subsets.forEach(currentSet -> lists.add(new ArrayList<>(currentSet)));
        return lists;
    }

    public static void addToList(Set<Set<Integer>> subsets, Set<Integer> set, int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                Set<Integer> newSet = new HashSet<>(set);
                newSet.add(nums[i]);
                subsets.add(newSet);
                addToList(subsets, newSet, nums);
            }


        }

    }

    public static List<List<Integer>> subsetsFast(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int num : nums) {

            List<List<Integer>> currentSubsets = new ArrayList<>();
            for (List<Integer> prevSubset : output) {
                List<Integer> currentSubset = new ArrayList<>(prevSubset);
                currentSubset.add(num);
                currentSubsets.add(currentSubset);
            }

            output.addAll(currentSubsets);


        }

        return output;
    }


}
