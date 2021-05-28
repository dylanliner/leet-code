public class ReverseInteger {
    public static void main(String[] args) {


        System.out.println(reverse(123));

    }

    public static int reverse(int x) {

        long previous = 0;
        long remainder = 0;
        long reverse = 0;
        while (x != 0) {
            remainder = x % 10;
            reverse = previous + remainder;
            if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
                return 0;
            }
            previous = reverse * 10;
            x = x / 10;
        }

        return (int) reverse;
    }
}
