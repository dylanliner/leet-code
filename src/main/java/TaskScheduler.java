import java.util.*;

public class TaskScheduler {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(solution.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }

    public static class Solution {


        public int leastInterval(char[] tasks, int n) {

            HashMap<Character, Integer> map = new HashMap<>();

            for (char c : tasks) {
                map.merge(c, 1, Integer::sum);
            }


            //parts

            int maxFrequency = Collections.max(map.values());
            int countOfMaxFrequency = (int) map.values().stream().filter(x -> x == maxFrequency).count();


            int nbOfParts = maxFrequency - 1;

            int lengthOfParts = n - countOfMaxFrequency + 1;

            //emptySlots
            int emptySlots = nbOfParts * lengthOfParts;


            //remainingCharacters

            int nbRemainingCharacters = tasks.length - countOfMaxFrequency * maxFrequency;

            //idles

            int idlesCount = Math.max(0, emptySlots - nbRemainingCharacters);


            return idlesCount + tasks.length;

        }


    }


}

