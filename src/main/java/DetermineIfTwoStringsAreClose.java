import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
        System.out.println(closeStrings("a", "aa"));
        System.out.println(closeStrings("cabbba", "abbccc"));
        System.out.println(closeStrings("cabbba", "aabbss"));
    }


    public static boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();

        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            map1.merge(word1.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < word2.length(); i++) {
            map2.merge(word2.charAt(i), 1, Integer::sum);
        }

        List<Integer> array1 = new ArrayList<>(map1.values());
        List<Integer> array2 = new ArrayList<>(map2.values());
        Collections.sort(array1);
        Collections.sort(array2);



        return array1.equals(array2) && map1.keySet().equals(map2.keySet());


    }
}
