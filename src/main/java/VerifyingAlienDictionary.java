import java.util.HashMap;

public class VerifyingAlienDictionary {

    public static void main(String[] args) {
//21:10
        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz"));
        System.out.println(isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz"));
    }


    public static boolean isAlienSorted(String[] words, String order) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('/', 0);
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i + 1);
        }

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i] + '/';
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {

                if (map.get(words[i].charAt(j)) > map.get(words[i + 1].charAt(j))) {
                    return false;
                } else if (map.get(words[i].charAt(j)).equals(map.get(words[i + 1].charAt(j)))) {
                    continue;
                } else {
                    break;
                }


            }

        }
        return true;
    }
}
