import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("101023"));
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));

    }

    public static List<String> restoreIpAddresses(String s) {

        if(s.length()>16){
            return new ArrayList<>();
        }

        List<String> mainList = new ArrayList<>();
        char[] charArray = s.toCharArray();


        addNumber(new StringBuilder(), charArray, 0, mainList, 0, 0);
        mainList.removeIf(el -> !isValid(el));

        return mainList;

    }

    private static boolean isValid(String string) {

        String[] stringArr = string.split("\\.");

        for (String s : stringArr) {
            if ((s.length() > 1 && s.charAt(0) == '0') || Integer.parseInt(s) > 255) {
                return false;
            }
        }

        return true;
    }

    private static void addNumber(StringBuilder prevSb, char[] charArray, int i, List<String> mainList, int pointCount, int lastPointIndex) {
        if (pointCount == 3 && i == charArray.length) {
            mainList.add(prevSb.toString());
        }
        if (i < charArray.length) {


            if (i - lastPointIndex < 3) {
                StringBuilder sb2 = new StringBuilder(prevSb);
                sb2.append(charArray[i]);
                addNumber(sb2, charArray, i + 1, mainList, pointCount, lastPointIndex);
            }

            if (i - lastPointIndex >= 1 && i - lastPointIndex < 4) {
                StringBuilder sb3 = new StringBuilder(prevSb);
                sb3.append('.');
                addNumber(sb3, charArray, i, mainList, pointCount + 1, i);
            }


        }
    }


}
