public class RangeSumOfBST {

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(10);
        treeNode2.left = new TreeNode(5);
        treeNode2.right = new TreeNode(15);
        treeNode2.left.left = new TreeNode(3);
        treeNode2.left.right = new TreeNode(7);
        treeNode2.right.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(treeNode2, 7, 15));

    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        return 0;
    }
}
