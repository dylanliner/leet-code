import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
//11:55
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(minRemoveToMakeValid("())()((("));


    }


    public static String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                stack.add(currentChar);
                sb.append(currentChar);
            } else if (currentChar == ')') {
                if (!stack.isEmpty()) {
                    Character lastChar = stack.peek();
                    if (lastChar == '(') {
                        stack.pop();
                        sb.append(currentChar);

                    }
                }
            } else {
                sb.append(currentChar);
            }


        }

        for (int i = sb.length()-1; !stack.isEmpty(); i--) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                stack.pop();
            }
        }


        return sb.toString();
    }
}
