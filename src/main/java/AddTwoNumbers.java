public class AddTwoNumbers {

    public static void main(String[] args) {


        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        ListNode node = addTwoNumbers(node1, node2);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode();
        ListNode head = node;
        while (l1 != null || l2 != null) {

            int sum = node.val;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }


            node.val = sum % 10;
            if(l1 != null || l2 != null || sum >= 10){
                node.next = new ListNode();
                if (sum >= 10) {
                    node.next.val = 1;
                }
            }

            node = node.next;


        }

        return head;

    }
}
