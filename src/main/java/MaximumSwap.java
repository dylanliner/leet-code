import java.util.*;

public class MaximumSwap {
    public static void main(String[] args) {


//        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        System.out.println(maximumSwap(
                98638));

    }

    public static int maximumSwap(int num) {

        String tempNum = Integer.toString(num);
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < tempNum.length(); i++) {

            list.add(Character.getNumericValue(tempNum.charAt(i)));
            if (!map.containsKey(Character.getNumericValue(tempNum.charAt(i)))) {
                map.put(Character.getNumericValue(tempNum.charAt(i)), new ArrayList<>());
            }
            map.get(Character.getNumericValue(tempNum.charAt(i))).add(i);
        }

        int swapIndex = 0;
        int maxIndex = 0;
        int j = 0;
        int i = 9;
        while (i >= 0) {
            if (map.containsKey(i)) {
                if (i == list.get(j)) {
                    map.get(i).remove(0);
                    j++;
                } else {
                    swapIndex = j;
                    maxIndex = map.get(i).get(map.get(i).size()-1);
                    break;
                }
                if (map.get(i).isEmpty()) {
                    i--;
                }
            } else {
                i--;
            }
        }

        int temp = list.get(maxIndex);
        list.set(maxIndex, list.get(swapIndex));
        list.set(swapIndex, temp);

        int total = 0;
        for (Integer l : list) { // assuming list is of type List<Integer>
            total = 10 * total + l;
        }
        return total;


    }
}
