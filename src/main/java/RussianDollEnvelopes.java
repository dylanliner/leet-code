import java.util.*;
import java.util.stream.Collectors;

public class RussianDollEnvelopes {

    public static void main(String[] args) {
        System.out.println(maxEnvelopes2(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(maxEnvelopes2(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
        System.out.println(maxEnvelopes2(new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}}));

    }

    public static int maxEnvelopes(int[][] envelopes) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < envelopes.length; i++) {
            pq.add(envelopes[i][0]);
            map.computeIfAbsent(envelopes[i][0], k -> new ArrayList<>()).add(envelopes[i][1]);
        }

        int prevHeight = 0;
        int prevWidth = 0;
        while (!pq.isEmpty()) {
            int width = pq.poll();
            int finalPrevHeight = prevHeight;
            Collections.sort(map.get(width));
            if (prevWidth < width && map.get(width).stream().anyMatch(height -> height > finalPrevHeight)) {
                count++;
                prevWidth = width;
                if (map.get(width).stream().anyMatch(height -> height > finalPrevHeight)) {
                    prevHeight = map.get(width).stream().filter(height -> height > finalPrevHeight).collect(Collectors.toList()).get(0);
                } else {
                    prevHeight = map.get(width).get(0);
                }
            }


        }


        return count;
    }

    public static int maxEnvelopes2(int[][] envelopes) {

        List<Integer> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < envelopes.length; i++) {
            list.add(envelopes[i][0]);
            map.computeIfAbsent(envelopes[i][0], k -> new ArrayList<>()).add(envelopes[i][1]);
        }

        map.forEach((Integer i, List<Integer> heights) -> {
            Collections.sort(heights);
        });

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            int width = list.get(i);
            int height = map.get(width).get(0);
            count = checkForSmaller(width, height, list, map, i - 1, 0) + checkForLarger(width, height, list, map, i + 1, 0) + 1;
            ;
            if (count > maxCount) {
                maxCount = count;
            }
        }


        return maxCount;
    }

    private static int checkForLarger(int width, int height, List<Integer> list, HashMap<Integer, List<Integer>> map, int i, int count) {

        if (i < 0 || i == list.size()) {
            return count;
        }
        if (list.get(i) > width && map.get(list.get(i)).stream().anyMatch(x -> x > height)) {
            return checkForLarger(list.get(i), map.get(list.get(i)).stream().filter(x -> x > height).collect(Collectors.toList()).get(0), list, map, i + 1, count + 1);
        } else {
            return checkForLarger(width, height, list, map, i + 1, count);
        }
    }

    private static int checkForSmaller(int width, int height, List<Integer> list, HashMap<Integer, List<Integer>> map, int i, int count) {

        if (i < 0 || i == list.size()) {
            return count;
        }
        if (list.get(i) < width && map.get(list.get(i)).stream().anyMatch(x -> x < height)) {
                return checkForSmaller(list.get(i), map.get(list.get(i)).stream().filter(x -> x < height).collect(Collectors.toList()).get(map.get(list.get(i)).stream().filter(x -> x < height).collect(Collectors.toList()).size() - 1), list, map, i - 1, count + 1);
        } else {
            return checkForSmaller(width, height, list, map, i - 1, count);
        }
    }
}
