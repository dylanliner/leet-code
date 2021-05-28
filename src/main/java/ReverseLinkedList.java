import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node5 = new ListNode(2);
        node.next = node5;
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node = reverseList(node);
        node = reverseIterativelyList(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public static ListNode reverseList(ListNode head) {
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }

        ListNode node2 = head;
        while (node2 != null) {
            node2.val= stack.pop();
            node2 = node2.next;
        }
        return head;

    }

    public static ListNode reverseIterativelyList(ListNode head) {
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }

        ListNode node2 = head;
        while (node2 != null) {
            node2.val= stack.pop();
            node2 = node2.next;
        }
        return head;

    }
}
