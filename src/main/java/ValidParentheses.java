import java.util.Arrays;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        String string = "{()[]{}}(";

        System.out.println(isValid(string));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char currentString : s.toCharArray()) {
            if (Arrays.asList('(', '[', '{').contains(currentString)) {
                stack.add(currentString);
            } else if (Arrays.asList(')', ']', '}').contains(currentString)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char lastString = stack.pop();
                    if (lastString != '{' && currentString == '}' || lastString != '(' && currentString == ')' || lastString != '[' && currentString == ']') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
