public class ValidateBinarySearchTree {

    public static void main(String[] args) {


        TreeNode treeNode2 = new TreeNode(5);
        treeNode2.left = new TreeNode(3);
        treeNode2.right = new TreeNode(6);
        treeNode2.left.left = new TreeNode(2);
        treeNode2.left.right = new TreeNode(4);
        treeNode2.left.left.left = new TreeNode(1);
        System.out.println(isValidBST(treeNode2));

    }

    public static boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long minLimit, long maxLimit) {
        if (root == null) {
            return true;
        }

        if (root.left != null &&  (root.left.val >= root.val || (root.left.val <= minLimit) || root.left.val >= maxLimit)) {
            return false;
        }
        if (root.right != null && (root.right.val <= root.val || root.right.val <= minLimit || (root.right.val >= maxLimit))) {
            return false;
        }


        return isValidBST(root.left, minLimit, root.val) && isValidBST(root.right, root.val, maxLimit);

    }


}
