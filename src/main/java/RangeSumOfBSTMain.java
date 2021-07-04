import org.w3c.dom.ranges.Range;

public class RangeSumOfBSTMain {

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(10);
        treeNode2.left = new TreeNode(5);
        treeNode2.right = new TreeNode(15);
        treeNode2.left.left = new TreeNode(3);
        treeNode2.left.right = new TreeNode(7);
        treeNode2.right.right = new TreeNode(18);
        RangeSumOfBST rangeSumOfBST = new RangeSumOfBST();

        System.out.println(rangeSumOfBST.rangeSumBST(treeNode2, 7, 15));
//22:13
    }

}
