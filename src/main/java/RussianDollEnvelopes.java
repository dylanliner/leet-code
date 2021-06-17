import java.util.*;
import java.util.stream.Collectors;

public class RussianDollEnvelopes {

    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
        System.out.println(maxEnvelopes(new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}}));

    }

    public static int maxEnvelopes(int[][] envelopes) {

        //Sort By w


        Arrays.sort(envelopes, (o1, o2) -> {
            if (o2[0] == o1[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        //if w are equals but the highest h first (because we want to fail on those when doing LIS)
        //Do LIS on h

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < envelopes.length; i++) {
            int current = envelopes[i][1];
            for (int j = 0; j < i; j++) {
                if ( envelopes[j][1]<current) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }

        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
