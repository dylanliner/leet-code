import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));

    }


    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i < charArray.length - 1 && charArray[i] == 'I') {
                if (charArray[i + 1] == 'V') {
                    num += 4;
                    i++;
                    continue;
                } else if (charArray[i + 1] == 'X') {
                    num += 9;
                    i++;
                    continue;
                }

            } else if (i < charArray.length - 1 && charArray[i] == 'X') {
                if (charArray[i + 1] == 'L') {
                    num += 40;
                    i++;
                    continue;
                } else if (charArray[i + 1] == 'C') {
                    num += 90;
                    i++;
                    continue;
                }

            } else if (i < charArray.length - 1 && charArray[i] == 'C') {
                if (charArray[i + 1] == 'D') {
                    num += 400;
                    i++;
                    continue;
                } else if (charArray[i + 1] == 'M') {
                    num += 900;
                    i++;
                    continue;
                }

            }
            num += map.get(charArray[i]);


        }

        return num;

    }
}
