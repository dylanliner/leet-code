public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {


        System.out.println(longestOnesSlidingWindow(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnesSlidingWindow(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));

//        21/46
        //10:26
    }

    public static int longestOnes(int[] nums, int k) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {

            int currentK = k;
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (currentK > 0 && nums[j] == 0) {
                    currentK--;
                    count++;
                } else if (nums[j] == 1) {
                    count++;
                } else if (nums[j] == 0) {
                    break;
                }

            }
            max = Math.max(max, count);
        }


        return max;
    }

    public static int longestOnesSlidingWindow(int[] nums, int k) {

        int max = 0;
        int zeroCount = 0;
        int tail = 0;
        for (int head = 0; head < nums.length; head++) {
            if (nums[head] == 0) {
                zeroCount++;
            }
            if (zeroCount > k) {
                if (nums[tail] == 0) {
                    zeroCount--;
                }
                tail++;
            }

            max = Math.max(max, head - tail + 1);


        }


        return max;
    }


}
