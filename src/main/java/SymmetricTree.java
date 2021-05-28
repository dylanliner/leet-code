import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(9);
        treeNode.left.left.right = new TreeNode(10);
        treeNode.right.right.right = new TreeNode(9);
        treeNode.right.right.left = new TreeNode(10);
        treeNode.left.right = new TreeNode(4);

        TreeNode treeNode2 = new TreeNode();
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(2);
        treeNode2.left.right = new TreeNode(3);
        treeNode2.right.right = new TreeNode(3);
        System.out.println(isSymmetric(treeNode));

    }

    public static boolean isSymmetric(TreeNode root) {


        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        treeTraversal1(root.left, list1);
        treeTraversal2(root.right, list2);

        return list1.equals(list2);

    }

    public static void treeTraversal1(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            treeTraversal2(node.left, list);
            treeTraversal1(node.right, list);
        } else {
            list.add(null);
        }


    }

    public static void treeTraversal2(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            treeTraversal1(node.right, list);
            treeTraversal2(node.left, list);
        } else {
            list.add(null);
        }


    }


}
