import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("&"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println("//");
        System.out.println(lengthOfLongestSubstringFast("abcabcbb"));
        System.out.println(lengthOfLongestSubstringFast("bbbbb"));
        System.out.println(lengthOfLongestSubstringFast("pwwkew"));
        System.out.println(lengthOfLongestSubstringFast(""));
        System.out.println(lengthOfLongestSubstringFast("&"));
        System.out.println(lengthOfLongestSubstringFast("au"));
        System.out.println(lengthOfLongestSubstringFast("abba"));

//        12:10
    }

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> chars = new HashSet<>();

        int currentCharIndex = 0;
        int currentWordStartIndex = 0;
        int maxLength = 0;
        int currentMaxLength = 0;
        while (currentCharIndex < s.length()) {
            Character currentChar = s.charAt(currentCharIndex);
            if (!chars.add(currentChar)) {
                currentWordStartIndex++;
                currentCharIndex = currentWordStartIndex;
                currentMaxLength = 0;
                chars.clear();
            } else {
                currentCharIndex++;
                currentMaxLength++;
            }
            maxLength = Math.max(currentMaxLength, maxLength);
        }

        return maxLength;
    }

    //NOT WORKING
    public static int lengthOfLongestSubstringFast(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {


            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right), right);

            max = Math.max(max, right - left+1);

        }

        return max;
    }
}
