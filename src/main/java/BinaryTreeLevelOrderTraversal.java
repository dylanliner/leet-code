import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.println(levelOrder(treeNode));

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        treeTraversal(root, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;!map.isEmpty();i++){
            list.add(map.remove(i));
        }
        return list;

    }

    public static void treeTraversal(TreeNode node, int level, HashMap<Integer, List<Integer>> map) {
        if (node != null) {
            if (map.get(level) != null) {
                map.get(level).add(node.val);

            } else {
                map.put(level, new ArrayList<>(Arrays.asList(node.val)));
            }
            treeTraversal(node.left, level + 1, map);
            treeTraversal(node.right, level + 1, map);
        }


    }
}
