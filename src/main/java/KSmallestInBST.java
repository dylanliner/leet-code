import java.util.PriorityQueue;

public class KSmallestInBST {

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(5);
        treeNode2.left = new TreeNode(3);
        treeNode2.right = new TreeNode(6);
        treeNode2.left.left = new TreeNode(2);
        treeNode2.left.right = new TreeNode(4);
        treeNode2.left.left.left = new TreeNode(1);
        System.out.println(kthSmallest(treeNode2, 3));

    }

    public static int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        treeTraversal(root, priorityQueue);
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.poll();
    }

    public static void treeTraversal(TreeNode node, PriorityQueue<Integer> priorityQueue) {

        if (node != null) {
            priorityQueue.add(node.val);
            treeTraversal(node.left, priorityQueue);
            treeTraversal(node.right, priorityQueue);

        }

    }

}
