import java.util.*;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(intersect(new int[]{4, 4, 9, 9, 6, 5}, new int[]{9, 4, 9, 8, 4, 6, 6})));
        System.out.println(Arrays.toString(intersectArray(new int[]{4, 4, 9, 9, 6, 5}, new int[]{9, 4, 9, 8, 4, 6, 6})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map1 = new HashMap();

        for (int i = 0; i < nums1.length; i++) {
            map1.merge(nums1[i], 1, Integer::sum);

        }

        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey(nums2[i]) && map1.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map1.merge(nums2[i], -1, Integer::sum);
            }

        }

        int[] itemsArray = new int[list.size()];
        for (int i = 0; i < itemsArray.length; i++) {
            itemsArray[i] = list.get(i);
        }
        return itemsArray;
    }

    public static int[] intersectArray(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int[] array = new int[1000];

        for (int i = 0; i < nums1.length; i++) {
            array[nums1[i]] = array[nums1[i]] + 1;

        }

        for (int i = 0; i < nums2.length; i++) {
            if (array[nums2[i]] > 0) {
                list.add(nums2[i]);
                array[nums2[i]] = array[nums2[i]] - 1;
            }

        }

        int[] itemsArray = new int[list.size()];
        for (int i = 0; i < itemsArray.length; i++) {
            itemsArray[i] = list.get(i);
        }
        return itemsArray;
    }
}
