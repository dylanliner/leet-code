public class FreshPromotion {

    private int startIndex = 0;

    public static void main(String[] args) {

        String[][] codeList1 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};


        String[][] codeList2 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};

        String[][] codeList3 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};

        String[][] codeList4 = {{"apple", "apple"}, {"apple", "apple", "banana"}};
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        FreshPromotion freshPromotion = new FreshPromotion();
        System.out.println(freshPromotion.freshPromotion(codeList1, shoppingCart1));
        System.out.println(freshPromotion.freshPromotion(codeList2, shoppingCart2));
        System.out.println(freshPromotion.freshPromotion(codeList3, shoppingCart3));
        System.out.println(freshPromotion.freshPromotion(codeList4, shoppingCart4));
        //15/17 15:39

    }

    private int freshPromotion(String[][] codeList, String[] shoppingCart) {

        for (String[] code : codeList) {
            if (isWinner(code, shoppingCart)) {
                continue;
            } else {
                return 0;
            }
        }
        return 1;
    }

    private boolean isWinner(String[] code, String[] shoppingCart) {

        int j = 0;
        for (int i = startIndex; i < shoppingCart.length; i++) {
            if (shoppingCart[i].equals(code[j]) || code[j].equals("anything")) {
                j++;
                if (j == code.length) {
                    startIndex = i + 1;
                    return true;
                }
            } else {
                j = 0;
            }
        }
        return false;
    }
}
