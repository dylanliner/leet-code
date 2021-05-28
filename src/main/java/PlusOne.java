import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {

        int[] numbers = {8, 9, 9};

        System.out.println(Arrays.toString(plusOne(numbers)));
    }

    public static int[] plusOne(int[] digits) {


        return recursion(digits, digits.length - 1);

    }

    public static int[] recursion(int[] digits, int index) {
        if (index == -1) {
            return move(digits);
        } else if (digits[index] == 9) {
            digits[index] = 0;
            return recursion(digits, index - 1);
        } else {
            digits[index] = digits[index] + 1;
        }
        return digits;
    }

    public static int[] move(int[] digits) {
        int[] newArr = new int[digits.length + 1];
        newArr[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            newArr[i + 1] = digits[i];
        }
        return newArr;

    }
}
