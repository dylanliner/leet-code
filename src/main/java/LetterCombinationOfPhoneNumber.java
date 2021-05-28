import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {

        System.out.println(letterCombinations(""));

    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        List<String> output = new ArrayList<>();


        recursion("", output, map, 0, digits);
        return output;

    }

    public static void recursion(String s, List<String> output, HashMap<Character, List<String>> map, int index, String digits) {
        if (index < digits.length()) {
            Character c = digits.charAt(index);

            for (int i = 0; i < map.get(c).size(); i++) {
                String newString = s + map.get(c).get(i);
                recursion(newString, output, map, index + 1, digits);
            }
        } else if (!s.equals("")) {
            output.add(s);
        }


    }
}
