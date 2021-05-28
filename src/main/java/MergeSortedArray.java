import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
//        merge(nums1, 3, nums2, 3);
//        System.out.println(Arrays.toString(nums1));

        int[] nums3 = new int[]{1};
        int[] nums4 = new int[]{};
//        merge(nums3, 1, nums4, 0);
//        System.out.println(Arrays.toString(nums3));

        int[] nums5 = new int[]{};
        int[] nums6 = new int[]{};
//        merge(nums5, 0, nums6, 0);
//        System.out.println(Arrays.toString(nums5));

        int[] nums7 = new int[]{2, 0};
        int[] nums8 = new int[]{1};
        merge(nums7, 1, nums8, 1);
        System.out.println(Arrays.toString(nums7));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];
        int i = 0;
        int j = 0;

        if (m != 0 && n == 0 || m == 0 && n == 0) {

        } else {

            for (int k = 0; k < m + n; k++) {

                if (j < n  && nums1[i] > nums2[j] || i >= m) {
                    temp[k] = nums2[j];
                    j++;
                } else {
                    temp[k] = nums1[i];
                    i++;
                }

            }
            for (int k = 0; k < nums1.length; k++) {

                nums1[k] = temp[k];

            }

        }
    }

}
