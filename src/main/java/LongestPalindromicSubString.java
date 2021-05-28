public class LongestPalindromicSubString {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("aaaa"));
//11:16

    }

    public static String longestPalindrome(String s) {
        String maxPalindrome = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                String palindrome = getMaxPalindrome(s, i, false);
                if (palindrome.length() > maxPalindrome.length()) {
                    maxPalindrome = palindrome;
                }
            }
            if (i + 2 < s.length() && s.charAt(i) == s.charAt(i + 2)) {
                String palindrome = getMaxPalindrome(s, i, true);
                if (palindrome.length() > maxPalindrome.length()) {
                    maxPalindrome = palindrome;
                }
            }

        }
        return maxPalindrome;
    }

    private static String getMaxPalindrome(String s, int i, boolean isOddPalindrome) {
        int j = i + 1;
        if (isOddPalindrome) {
            j = j + 1;
        }
        while (i > 0 && j < s.length() - 1 && s.charAt(i - 1) == s.charAt(j + 1)) {
            i--;
            j++;
        }
        return s.substring(i, j + 1);


    }
}
