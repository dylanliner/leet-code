public class CountPrimes {

    public static void main(String[] args) {
        //System.out.println(countPrimes(499979));
        System.out.println(dpCountPrimes(499979));

    }

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }

        }
        return count;
    }

    public static int dpCountPrimes(int n) {
        int count = 0;
        boolean[] isNotPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if(!isNotPrime[i]){
                count++;
            }
            for (int j = 2; i*j < n; j++) {
                isNotPrime[i*j]=true;
            }

        }
        return count;
    }


}
