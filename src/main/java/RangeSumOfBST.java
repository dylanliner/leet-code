public class RangeSumOfBST {

    private int sum = 0;


    public int rangeSumBST(TreeNode root, int low, int high) {
        treeTraversal(root, low, high);

        return sum;
    }

    private void treeTraversal(TreeNode root, int low, int high) {

        if (root != null) {
            if (low <= root.val && root.val <= high) {
                sum = sum + root.val;
            }
            treeTraversal(root.left, low, high);
            treeTraversal(root.right, low, high);
        }

    }

}

