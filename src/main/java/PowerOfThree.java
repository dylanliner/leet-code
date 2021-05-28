public class PowerOfThree {

    public static void main(String[] args) {

        System.out.println(isPowerOfThree(729));

    }

    public static boolean isPowerOfThree(int n) {

        if (n == 0) {
            return false;
        }

        while (n % 3 == 0) {
            if (n == 3) {
                return true;
            }
            n = n / 3;

        }
        return n == 1;
    }
}
