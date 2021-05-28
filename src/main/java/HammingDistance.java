public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(compareStrings2(1, 4));
    }

    public static int hammingDistance(int x, int y) {

        String binaryStringX = Integer.toBinaryString(x);
        String binaryStringY = Integer.toBinaryString(y);

        System.out.println(Integer.toBinaryString(3 ^ 3));
        int leadingZeros = 0;
        if (binaryStringX.length() > binaryStringY.length()) {
            leadingZeros = binaryStringX.length() - binaryStringY.length();
            binaryStringY = addLeadingZeros(leadingZeros, binaryStringY);
        } else if (binaryStringX.length() < binaryStringY.length()) {
            leadingZeros = binaryStringY.length() - binaryStringX.length();
            binaryStringX = addLeadingZeros(leadingZeros, binaryStringX);

        }
        return compareStrings(binaryStringX, binaryStringY);


    }

    private static String addLeadingZeros(int leadingZeros, String string) {
        String newString = "";
        for (int i = 0; i < leadingZeros; i++) {
            newString += "0";
        }
        newString += string;

        return newString;

    }

    private static int compareStrings(String binaryStringX, String binaryStringY) {
        int differences = 0;
        for (int i = 0; i < binaryStringX.length(); i++) {
            if (binaryStringX.charAt(i) != binaryStringY.charAt(i)) {
                differences++;
            }
        }
        return differences;

    }

    private static int compareStrings2(int i, int y) {

        return Integer.bitCount(i ^ y);
    }

}
