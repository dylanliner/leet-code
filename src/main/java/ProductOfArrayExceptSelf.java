import java.util.Arrays;
import java.util.stream.IntStream;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 0})));
    }

    public static int[] productExceptSelf(int[] nums) {

        int ans[] = new int[nums.length];

        int product = IntStream.of(nums).reduce(1, (x, y) -> x * y);
        long count0 = IntStream.of(nums).filter(x -> x == 0).count();
        int productWithout0 = 0;
        if (count0 == 1) {
            productWithout0 = IntStream.of(nums).filter(x -> x != 0).reduce(1, (x, y) -> x * y);
        }

        for (int i = 0; i < nums.length; i++) {
            if (count0 == 1 && nums[i] == 0) {
                ans[i] = productWithout0;
            } else if(count0 > 1 && nums[i] == 0){
                ans[i] = product;
            }else{
                ans[i] = product * nums[i];
            }


        }

        return ans;
    }

    private static int compute(int i, int[] nums) {
        int prod = 1;
        for (int j = 0; j < nums.length; j++) {
            if (j == i) {
                continue;
            } else {
                prod = prod * nums[j];
            }


        }
        return prod;
    }
}
