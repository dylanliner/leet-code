import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);

        System.out.println(rightSideView(treeNode));

    }

    public static List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        rightSideView(root, map, 0);

        for (int i = 0; map.get(i) != null; i++) {
            list.add(map.get(i));
        }

        return list;


    }

    private static void rightSideView(TreeNode root, HashMap<Integer, Integer> map, int level) {
        if (root != null) {
            map.put(level, root.val);
            rightSideView(root.left, map, level + 1);
            rightSideView(root.right, map, level + 1);
        }
    }


}
