import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<List<Character>, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            List<Character> list = new ArrayList<>();

            for (char ch : s.toCharArray()) {
                list.add(ch);
            }
            Collections.sort(list);
            if (!map.containsKey(list)) {
                map.put(list, new ArrayList<>());
            }
            map.get(list).add(s);

        }

        List<List<String>> res = new ArrayList<>();

        map.forEach((key, value) -> res.add(value));
        return res;

    }
}
