

public class ConvertSortedArrayToBST {
    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5}));

    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        return insertInTree(0,nums.length-1,nums);

    }


    private static void insertInTree(TreeNode node, int currentNum) {

        if (currentNum > node.val)
            if (node.right == null) {
                node.right = new TreeNode(currentNum);
            } else {
                insertInTree(node.right, currentNum);
            }
        if (currentNum < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(currentNum);
            } else {
                insertInTree(node.left, currentNum);
            }
        }
    }

    private static TreeNode insertInTree(int low, int high, int[] nums) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = insertInTree(low, mid - 1, nums);
        node.right = insertInTree(mid + 1, high, nums);

        return node;
    }
}
