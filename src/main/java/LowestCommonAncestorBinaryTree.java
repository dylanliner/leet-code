public class LowestCommonAncestorBinaryTree {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.println(lowestCommonAncestor(treeNode, treeNode.right.right, treeNode.right.left).val);
//11:16

    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            TreeNode lca1 = lowestCommonAncestor(root.left, p, q);
            TreeNode lca2 = lowestCommonAncestor(root.right, p, q);
            if (lca1 != null) {
                return lca1;
            } else if (lca2 != null) {
                return lca2;
            }
            if (isDescendant(root.left, p) && isDescendant(root.right, q) || isDescendant(root.right, p) && isDescendant(root.left, q) ||
                    isDescendant(root, p) && isDescendant(root.right, q) || isDescendant(root.right, p) && isDescendant(root, q) ||
                    isDescendant(root, p) && isDescendant(root.left, q) || isDescendant(root.left, p) && isDescendant(root, q)
            ) {
                return root;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }


    private static boolean isDescendant(TreeNode node, TreeNode p) {
        if (node != null) {
            if (node == p) {
                return true;
            } else {
                return isDescendant(node.left, p) || isDescendant(node.right, p);
            }
        } else {
            return false;
        }
    }
}
