public class PowOfXN {
    public static void main(String[] args) {

        System.out.println(myPow(-1.00000, -2147483648));

    }

    public static double myPow(double x, int n) {
        long n2 = n;

        double ans = 1;
        if (x == 1.0) {
            return 1;
        }

        if (x == -1.0) {
            if (n2 % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }


        if (n2 < 0) {
            x = 1 / x;
            n2 = -n2;
        }

        for (int i = 0; i < n2; i++) {
            if (ans == ans * x) {
                return ans;
            }
            ans = ans * x;

        }
        return ans;

    }
}
