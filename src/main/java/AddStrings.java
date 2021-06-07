import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AddStrings {
    public static void main(String[] args) {


        System.out.println(addStrings("18", "123"));
    }

    public static String addStrings(String num1, String num2) {

        List<Character> l1 = num1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> l2 = num2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.reverse(l1);
        Collections.reverse(l2);
        StringBuffer sb = new StringBuffer();
        int remainder = 0;
        for (int i = 0; i < Math.max(l1.size(), l2.size()); i++) {
            int ascii1 = 0;
            int ascii2 = 0;
            if (i < l1.size()) {
                ascii1 = l1.get(i) - 48;
            }
            if (i < l2.size()) {
                ascii2 = l2.get(i) - 48;
            }

            int res = ascii1 + ascii2 + remainder;
            if (res - 10 > 0) {
                res = res - 10;
                remainder = 1;
            } else {
                remainder = 0;
            }
            sb.append(String.valueOf(res));
        }
        sb.reverse();
        return sb.toString();

    }
}
