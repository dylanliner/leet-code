import java.util.Arrays;

public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(3);
        node.right.left = new Node(7);
        node.right.right = new Node(6);

        System.out.println(connect(node));
    }


    public static Node connect(Node root) {
        return root;
    }
}
