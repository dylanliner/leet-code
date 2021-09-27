import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalStoragePieceOfCake {

    public static void main(String[] args) {
        //int h = 5, w = 4;
        //int[] horizontalCuts = {1, 2, 4}, verticalCuts = {1, 3};

        //int h = 5, w = 4;
        //int[] horizontalCuts = {3, 1}, verticalCuts = {1};

        int h = 1000000000, w = 1000000000;
        int[] horizontalCuts = {2}, verticalCuts = {2};


        System.out.println(maxArea(h, w, horizontalCuts, verticalCuts));
        //22:45 //23:11
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000007;

        long maxV = 0;
        long maxH = 0;
        horizontalCuts = Arrays.copyOf(horizontalCuts, horizontalCuts.length + 1);
        verticalCuts = Arrays.copyOf(verticalCuts, verticalCuts.length + 1);
        horizontalCuts[horizontalCuts.length - 1] = h;
        verticalCuts[verticalCuts.length - 1] = w;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);


        for (int i = 0; i < horizontalCuts.length; i++) {


            int hLength = i == 0 ? horizontalCuts[i] : horizontalCuts[i] - horizontalCuts[i - 1];
            maxH = Math.max(maxH, hLength);


        }

        for (int j = 0; j < verticalCuts.length; j++) {
            int vLength = j == 0 ? verticalCuts[j] : verticalCuts[j] - verticalCuts[j - 1];
            maxV = Math.max(maxV, vLength);

        }

        return (int) ((maxV * maxH) % mod);
    }
}
