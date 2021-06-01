import java.util.*;

public class BinaryTreeZigZagLevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(3);
        treeNode2.left.left = new TreeNode(4);


        treeNode2.right.right = new TreeNode(5);

        System.out.println(zigzagLevelOrder(treeNode2));

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        zigzagLevelOrder(root, map, 0);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; map.get(i) != null; i++) {
            if (i % 2 != 0) {
                Collections.reverse(map.get(i));
            }
            list.add(map.get(i));
        }
        return list;
    }

    public static void zigzagLevelOrder(TreeNode node, Map<Integer, List<Integer>> map, int level) {

        if (node != null) {
            if (!map.containsKey(level)) {
                map.put(level, new ArrayList<>());
            }
            map.get(level).add(node.val);

            zigzagLevelOrder(node.left, map, level + 1);
            zigzagLevelOrder(node.right, map, level + 1);


        }
    }
}
