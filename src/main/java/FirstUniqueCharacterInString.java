import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));

    }

    public static int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[(int) c - 97] >= 1) {
                arr[(int) c - 97] = -1;
            } else if (arr[(int) c - 97] == 0) {
                arr[(int) c - 97] = 1 + i;
            }

        }
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 1 && minIndex > arr[i] - 1) {
                minIndex = arr[i] - 1;
            }
        }
        if (minIndex == Integer.MAX_VALUE) {
            return -1;
        }
        return minIndex;
    }

}
