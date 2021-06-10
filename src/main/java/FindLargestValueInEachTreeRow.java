import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindLargestValueInEachTreeRow {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(9);

        System.out.println(largestValues(treeNode));

    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        findLargest(root, map, 0);

        for (int i = 0; map.get(i) != null; i++) {
            ans.add(map.get(i));
        }

        return ans;

    }

    private static void findLargest(TreeNode root, HashMap<Integer, Integer> map, int level) {
        if (root != null) {
            if (!map.containsKey(level) || (map.containsKey(level) && map.get(level) < root.val)) {
                map.put(level, root.val);
            }
            findLargest(root.left, map, level + 1);
            findLargest(root.right, map, level + 1);
        }

    }


}
