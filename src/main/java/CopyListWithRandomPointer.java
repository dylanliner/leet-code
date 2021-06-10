import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {

        Node node = new Node(7);
        node.next = new Node(13);
        node.next.next = new Node(11);
        node.next.next.next = new Node(10);
        node.next.next.next.next = new Node(1);
        node.random = null;
        node.next.random = node;
        node.next.next.random = node.next.next.next.next;
        node.next.next.next.random = node.next.next;
        node.next.next.next.next.random = node;

        Node copyNodeHead = copyRandomList(node);
        while (copyNodeHead != null) {
            System.out.println(copyNodeHead.val);
            if (copyNodeHead.random != null) {
                System.out.println(copyNodeHead.random.val);
            } else {
                System.out.println("null");
            }

            copyNodeHead = copyNodeHead.next;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        Node copyNode = new Node(0);
        Node copyNodeHead = copyNode;
        HashMap<Integer, Node> map = new HashMap<>();
        HashMap<Node, List<Integer>> map2 = new HashMap<>();
        int count = 0;
        while (node != null) {
            copyNode.val = node.val;
            if (node.next != null) {
                copyNode.next = new Node(0);
            }
            if (node.random != null) {
                if (!map2.containsKey(node.random)) {
                    map2.put(node.random, new ArrayList<>());
                }
                map2.get(node.random).add(count);
            }
            count++;
            copyNode = copyNode.next;
            node = node.next;
        }
        count = 0;
        node = head;
        copyNode = copyNodeHead;
        while (node != null) {

            if (map2.containsKey(node)) {

                for (int i : map2.get(node)) {
                    map.put(i, copyNode);
                }

            }
            count++;
            node = node.next;
            copyNode = copyNode.next;
        }

        copyNode = copyNodeHead;
        count = 0;
        while (copyNode != null) {

            copyNode.random = map.get(count);
            copyNode = copyNode.next;
            count++;

        }

        return copyNodeHead;
    }
}
