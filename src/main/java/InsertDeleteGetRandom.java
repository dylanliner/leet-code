public class InsertDeleteGetRandom {

    public static void main(String[] args) {

        RandomizedCollection randomizedCollection = new RandomizedCollection();
//10:40
        System.out.println(randomizedCollection.insert(0));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.remove(0));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.remove(1));
        System.out.println(randomizedCollection.getRandom());

    }


}
