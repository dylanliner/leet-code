import java.util.*;

public class RotationalCipher {

    public static void main(String[] args) {

        System.out.println(rotationalCipher("abcdZXYzxy-999.@", 200));
    }

    static String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        String s = "";

        for (char c : input.toCharArray()) {
            int asciivalue1 = c;
            if (Character.isLetterOrDigit(c)) {
                if (Character.isLetter(c)) {
                    asciivalue1 = c + rotationFactor % 26;
                } else {
                    asciivalue1 = c + rotationFactor % 10;
                }


                if (64 < c && c < 91 && asciivalue1 > 90) {
                    asciivalue1 = asciivalue1 - 26;
                }
                if (96 < c && c < 123 && asciivalue1 > 122) {
                    asciivalue1 = asciivalue1 - 26;
                }
                if (47 < c && c < 58 && asciivalue1 > 57) {
                    asciivalue1 = asciivalue1 - 10;
                }
            }
            s = s + (char) asciivalue1;
        }
        return s;

    }



}
