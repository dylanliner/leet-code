import java.util.ArrayList;
import java.util.List;

public class OddEvenLinkedList {

    public static void main(String[] args) {


        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        ListNode node = oddEvenList2(node1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
//        11:45
    }

    public static ListNode oddEvenList(ListNode head) {

        int i = 1;
        ListNode node = head;
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        while (node != null) {
            if (i % 2 == 0) {
                evens.add(node.val);
            } else {
                odds.add(node.val);
            }
            node = node.next;
            i++;
        }
        node = head;
        odds.addAll(evens);

        for (int j = 0; j < odds.size(); j++) {
            node.val = odds.get(j);
            node = node.next;
        }
        return head;

    }

    public static ListNode oddEvenList2(ListNode head) {

        int i = 1;
        ListNode node = head;
        if(head==null || head.next ==null) return head;
        ListNode reorderedNodeLeft = new ListNode();
        ListNode reorderedNodeRight = new ListNode();
        ListNode reorderedNodeLeftHead = reorderedNodeLeft;
        ListNode reorderedNodeRightHead = reorderedNodeRight;
        while (node != null) {
            if (i % 2 == 0) {
                reorderedNodeRight.val = node.val;
                if (node.next != null && node.next.next != null) {
                    reorderedNodeRight.next = new ListNode();
                    reorderedNodeRight = reorderedNodeRight.next;
                }
            } else {
                reorderedNodeLeft.val = node.val;
                if (node.next != null && node.next.next != null) {
                    reorderedNodeLeft.next = new ListNode();
                    reorderedNodeLeft = reorderedNodeLeft.next;
                }
            }
            node = node.next;
            i++;
        }

        reorderedNodeLeft.next = reorderedNodeRightHead;
        return reorderedNodeLeftHead;

    }
}
