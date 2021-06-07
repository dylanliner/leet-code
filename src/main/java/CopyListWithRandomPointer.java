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

        System.out.println(copyRandomList(node));

    }

    public static Node copyRandomList(Node head) {

        return head;
    }
}
