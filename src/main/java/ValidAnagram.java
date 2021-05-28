import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {

        System.out.println(isAnagram("ab", "a"));

    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] array = new int[26];


        for (Character c1 : s.toCharArray()) {
            array[(int) c1 - 97] = array[(int) c1 - 97] + 1;
        }
        for (Character c2 : t.toCharArray()) {
            if (array[(int) c2 - 97] == 0) {
                return false;
            } else {
                array[(int) c2 - 97] = array[(int) c2 - 97] - 1;
            }
        }


        return true;

    }
}
