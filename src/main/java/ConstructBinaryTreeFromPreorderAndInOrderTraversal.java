import com.sun.source.tree.Tree;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInOrderTraversal {

    public static void main(String[] args) {
        //System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
        //System.out.println(buildTree(new int[]{1, 2}, new int[]{1, 2}));
        //System.out.println(buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
        //System.out.println(buildTree(new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 4}));
        System.out.println(buildTree(new int[]{1, 2}, new int[]{2, 1}));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, new TreeNode(), map, 0, preorder.length, 0);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, TreeNode currentNode, HashMap<Integer, Integer> map, int preoderIndex, int inorderRightLimit, int inorderLeftLimit) {

        if (preoderIndex < preorder.length) {
            int currentNodeVal = preorder[preoderIndex];
            int currentNodeValueInorderIndex = map.get(currentNodeVal);
            if (inorderRightLimit > currentNodeValueInorderIndex && inorderLeftLimit <= currentNodeValueInorderIndex) {
                currentNode.val = currentNodeVal;

                currentNode.left = new TreeNode();
                currentNode.right = new TreeNode();

                currentNode.left = buildTree(preorder, inorder, currentNode.left, map, preoderIndex + 1, map.get(currentNodeVal), 0);
                if (currentNode.left == null) {
                    currentNode.right = buildTree(preorder, inorder, currentNode.right, map, preoderIndex + 1, inorderRightLimit, 0);
                } else {
                    currentNode.right = null;
                    for (int i = preoderIndex + 2; i < preorder.length; i++) {
                        currentNode.right = new TreeNode();
                        currentNode.right = buildTree(preorder, inorder, currentNode.right, map, i, inorderRightLimit, map.get(currentNodeVal));
                        if (currentNode.right != null) {
                            break;
                        }
                    }

                }

            } else {
                currentNode = null;
            }

        } else {
            currentNode = null;
        }

        return currentNode;
    }


}
