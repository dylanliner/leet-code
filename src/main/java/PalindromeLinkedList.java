import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node5 = new ListNode(3);
        node.next = node5;
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(1);
//        node.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(node));

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static boolean isPalindrome(ListNode head) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        int midway = count / 2;
        boolean isOdd = count % 2 != 0;
        count = 0;

        ListNode fastRunner = head;
        while (fastRunner != null) {
            if (count < midway) {
                stack.add(fastRunner.val);
            } else if ((!isOdd && stack.pop() != fastRunner.val) || (isOdd && count > midway && stack.pop() != fastRunner.val)) {
                return false;
            }

            count++;
            fastRunner = fastRunner.next;
        }


        return true;


    }
}
