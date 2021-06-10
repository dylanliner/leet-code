import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KokoEatingBananas {

    public static void main(String[] args) {
//        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{312884470}, 312884469));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int min = 0;
        int max = Arrays.stream(piles).max().getAsInt();
        int k = 0;
        //Binary Search
        while (min < max) {
            k = (min + max) / 2;
            if (!canEatAll(piles, h, k)) {
                min = k + 1;
            } else {
                max = k;
            }

        }
        return min;
    }

    private static boolean canEatAll(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles) {
            time = (int) (time + Math.ceil((double) pile / k));

        }
        return time <= h;
    }

//    public static int minEatingSpeed(int[] piles, int h) {
//
//        int sum = Arrays.stream(piles).sum();
//
//        int k = 0;
//        int eaten = 0;
//        int min = 0;
//        int max = Arrays.stream(piles).max().getAsInt();
//        int h2 = 0;
//        while (!(eaten == sum && h2 == h)) {
//            if (eaten < sum) {
//                min = k;
//            } else {
//                max = k;
//            }
//            k = (min + max) / 2;
//            eaten = 0;
//
//            int[] piles2 = new int[piles.length];
//            for (int l = 0; l < piles.length; l++) {
//                piles2[l] = piles[l];
//            }
//            h2=0;
//
//            int j = 0;
//            while (h2 != h && j != piles.length) {
//                int pile = piles2[j];
//                if (pile <= k) {
//                    eaten = eaten + pile;
//                    piles2[j] = 0;
//                    j++;
//                } else {
//                    eaten = eaten + k;
//                    piles2[j] = pile - k;
//                }
//                h2++;
//            }
//
//        }
//
//
//        return k;
//
//    }
}
