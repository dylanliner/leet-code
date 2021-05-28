public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node5 = new ListNode(2);
        node.next = node5;
        node.next.next = new ListNode(4);


        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        ;
        node1.next.next = new ListNode(4);

        ListNode newNode = mergeTwoLists(node, node1);

        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 ==null){
            return null;
        }
        ListNode output = new ListNode(0);
        ListNode head = output;

        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    output.val = l2.val;
                    l2 = l2.next;
                } else {
                    output.val = l1.val;
                    l1 = l1.next;
                }
            } else if (l1 == null) {
                output.val = l2.val;
                l2 = l2.next;

            } else {
                output.val = l1.val;
                l1 = l1.next;
            }
            if(l1 != null || l2 != null){
                output.next = new ListNode(0);
                output = output.next;
            }

        }

        return head;

    }
}
