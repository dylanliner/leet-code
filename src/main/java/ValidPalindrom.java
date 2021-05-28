import java.util.Locale;

public class ValidPalindrom {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s2 = "radar";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {

        s = s.replaceAll("[\\W]|_", "");
        s = s.toLowerCase();
        int i = (s.length() / 2) - 1;
        int j = (s.length() / 2);
        if (s.length() % 2 != 0) {
            j = j + 1;
        }
        while (j < s.length()) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j++;
            i--;
        }
        return true;
    }
}
