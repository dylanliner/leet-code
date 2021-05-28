import java.util.List;

public class DeleteNodeLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node5;
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);

        deleteNode(node5);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static void deleteNode(ListNode node) {
        while (node != null) {
            node.val = node.next.val;

            if(node.next.next==null){
                node.next=null;
            }
            node = node.next;
        }
    }
}
