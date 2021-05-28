public class MaximumDepthofBST {

    public static void main(String[] args) {


        TreeNode treeNode2 = new TreeNode(10);
        treeNode2.left = new TreeNode(5);
        treeNode2.right = new TreeNode(15);
        treeNode2.right.left = new TreeNode(Integer.MIN_VALUE);
        treeNode2.right.right = new TreeNode(20);
        System.out.println(maxDepth(treeNode2));

    }

    public static int maxDepth(TreeNode root) {

        return maxDepth(root,0);
    }

    public static int maxDepth(TreeNode node, int maxDepth) {

        if (node == null) {
            return maxDepth;
        } else {
            return Math.max(maxDepth(node.left, maxDepth + 1), maxDepth(node.right, maxDepth + 1));
        }


    }
}
