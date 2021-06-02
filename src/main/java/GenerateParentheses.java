import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GenerateParentheses {
    public static void main(String[] args) {
        //System.out.println(countPrimes(499979));
        System.out.println(generateParenthesis(3));

    }

    public static List<String> generateParenthesis(int n) {
        String s = "";
        List<String> list = new ArrayList<>();
        generateParenthesis(s, "(", n - 1, n, list);
        return list.stream().filter(GenerateParentheses::isValid).collect(Collectors.toList());
    }

    private static void generateParenthesis(String s, String parenthesis, int open, int close, List<String> list) {
        s = s + parenthesis;
        if (close == 0 && open == 0) {
            list.add(s);
        } else {
            if (open == 0) {
                generateParenthesis(s, ")", open, close - 1, list);
            } else if (close == 0) {
                generateParenthesis(s, "(", open - 1, close, list);
            } else {
                generateParenthesis(s, "(", open - 1, close, list);
                generateParenthesis(s, ")", open, close - 1, list);
            }

        }

    }

    private static boolean isValid(String s) {
        int pairs = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                pairs++;
            } else {
                pairs--;
            }
            if (pairs < 0) {
                return false;
            }
        }
        return true;


    }


}
