import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NthDigit {
    public static void main(String[] args) {


        System.out.println(findNthDigit(1000000000));
        System.out.println(findNthDigit2(1000000000));
    }

    public static int findNthDigit(int n) {

        int startOfRange = 1;
        long rangeOfNumber = 9;
        int lengthOfNumber = 1;
        //Get number range of Nth Digit
        while (n > rangeOfNumber * lengthOfNumber) {
            n = (int) (n - rangeOfNumber * lengthOfNumber);
            lengthOfNumber++;
            rangeOfNumber = rangeOfNumber * 10;
            startOfRange = startOfRange * 10;
        }

        int exactNumber = startOfRange + (n - 1) / lengthOfNumber;
        //Get exact number of Nth Digit
        String exactNumberString = Integer.toString(exactNumber);
        //Get digit within exact number of Nth Digit
        return Character.getNumericValue(exactNumberString.charAt((n - 1) % lengthOfNumber));


    }

    public static int findNthDigit2(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
