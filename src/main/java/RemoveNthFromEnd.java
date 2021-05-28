public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node5 = new ListNode(2);
//        node.next = node5;
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        node = removeNthFromEnd(node, 1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        if (count - n == 0) {
            if (head.next != null) {
                head = head.next;
                return head;
            } else {
                return null;
            }

        }

        int count2 = 0;
        node = head;


        while (count2 <= count - n) {
            if (count2 == count - n - 1) {
                node.next = node.next.next;
            }
            node = node.next;
            count2++;

        }
        return head;
    }
}
