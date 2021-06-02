import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(3);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        System.out.println(connect2(node));
    }


    public static Node connect(Node root) {
        Map<Integer, Node> map = new HashMap<>();
        findNext(map, root, 0);
        return root;
    }

    public static Node connect2(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        root.left.next = root.right;
        connect2(root.left);
        connect2(root.right);

        return root;
    }

    public static void findNext(Map<Integer, Node> map, Node node, int level) {

        if (node != null) {
            if (!map.containsKey(level)) {
                map.put(level, node);
            } else {
                insert(map.get(level), node);
            }

            findNext(map, node.left, level + 1);
            findNext(map, node.right, level + 1);
        }
        ;


    }

    private static void insert(Node node, Node node1) {

        while (node.next != null) {
            node = node.next;
        }
        node.next = node1;

    }


}
