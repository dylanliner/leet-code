public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node5 = new ListNode(3);
        node.next = node5;
        node.next.next = new ListNode(3);
        node.next.next.next = node5;
//        node.next.next.next.next = new ListNode(1);
        System.out.println(hasCycle(node));

//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }
    }

    public static boolean hasCycle(ListNode head) {

        ListNode slowRunner = head;
        ListNode fastRunner = head;

        while (fastRunner != null && fastRunner.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
            if (fastRunner == slowRunner) {
                return true;
            }

        }
        return false;
    }
}
