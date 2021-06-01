import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

        ListNode node3 = new ListNode(8);
        node3.next = new ListNode(4);
        node3.next.next = new ListNode(5);

        ListNode node1 = new ListNode(4);
        node1.next = new ListNode(1);
        node1.next.next = node3;

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(1);
        node2.next.next.next = node3;

        System.out.println(getIntersectionNode(node1, node2).val);
        //23:30

    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> set = new HashSet<>();

        while (headA != null || headB != null) {

            if (headA != null) {
                if (!set.add(headA)) {
                    return headA;
                }

                headA = headA.next;
            }

            if (headB != null) {
                if (!set.add(headB)) {
                    return headB;
                }

                headB = headB.next;
            }


        }
        return null;
    }
}
