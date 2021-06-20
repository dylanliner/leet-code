import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {

        String string = "catsanddog";

        System.out.println(wordBreak(string, Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple")));

    }

    public static List<String> wordBreak(String s, List<String> wordDict) {

        //trie

        List<String> ans = new ArrayList<>();

        nextWord(s, 0, new StringBuilder(), new HashSet<>(wordDict), ans);

        return ans;
    }

    private static void nextWord(String s, int i, StringBuilder phraseBuilder, HashSet<String> set, List<String> ans) {
        if (i < s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));

                if (set.contains(sb.toString())) {
                    StringBuilder newPhraseBuilder = new StringBuilder(phraseBuilder);
                    newPhraseBuilder.append(" " + sb.toString());
                    nextWord(s, j + 1, newPhraseBuilder, set, ans);
                }
                ;
            }

        } else {
            ans.add(phraseBuilder.deleteCharAt(0).toString());
        }


    }

    private static boolean isInTrie(String s, Trie trie, int i) {
        if (i < s.length()) {
            if (trie.nextCharacter.containsKey(s.charAt(i))) {
                return isInTrie(s, trie.nextCharacter.get(s.charAt(i)), i + 1);
            } else {
                return false;
            }
        } else {
            return true;
        }


    }

    private static void insertInTrie(String s, Trie trie, int i) {

        if (i < s.length()) {
            if (trie.nextCharacter.containsKey(s.charAt(i))) {
                insertInTrie(s, trie.nextCharacter.get(s.charAt(i)), i + 1);
            } else {

                trie.nextCharacter.put(s.charAt(i), new Trie());
                if (i == s.length() - 1) {
                    trie.nextCharacter.put('.', new Trie());
                }
            }
        }


    }


}
