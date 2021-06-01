import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);


        System.out.println(inorderTraversal(treeNode));
//0:11
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;

    }

    public static void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            inOrderTraversal(node.left, list);
            list.add(node.val);
            inOrderTraversal(node.right, list);
        }
    }
}
