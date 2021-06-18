public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);

        System.out.println();
        String s = serialize(treeNode);
        System.out.println(s);
        deserialize(s);
        //10:46

    }

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traversal(sb, root);
        return sb.toString();
    }

    public static void traversal(StringBuilder sb, TreeNode node) {
        if (node != null) {
            sb.append("," + node.val);
            traversal(sb, node.left);
            traversal(sb, node.right);
        } else {
            sb.append("," + "end");
        }
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        TreeNode ans = new TreeNode();
        deserializeTraversal(ans, strings, 1);

        return ans;

    }

    public static int deserializeTraversal(TreeNode currentNode, String[] strings, int i) {

        if (!strings[i].equals("end")) {
            currentNode.val = Integer.parseInt(strings[i]);
            currentNode.left = new TreeNode();
            currentNode.right = new TreeNode();
            int rightIndex = deserializeTraversal(currentNode.left, strings, i + 1);
            return deserializeTraversal(currentNode.right, strings, rightIndex);
        } else {
            currentNode = null;
        }
        return i + 1;

    }
}
