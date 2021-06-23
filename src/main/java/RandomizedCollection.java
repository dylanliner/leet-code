import java.util.*;

public class RandomizedCollection {


    private HashMap<Integer, Stack<Integer>> mapOfIndices = new HashMap<>();
    private ArrayList<Integer> list = new ArrayList<>();
    private int offset = 0;

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!mapOfIndices.containsKey(val)) {
            list.add(val);
            mapOfIndices.computeIfAbsent(val, x -> new Stack<>()).add(list.size() - 1);
            return true;
        } else {
            list.add(val);
            mapOfIndices.computeIfAbsent(val, x -> new Stack<>()).add(list.size() - 1);
            return false;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {

        if (mapOfIndices.containsKey(val)) {
            list.remove((int) mapOfIndices.get(val).pop());
            offset = offset + 1;
            if (mapOfIndices.get(val).size() == 0) {
                mapOfIndices.remove(val);
            }
            return true;
        }
        return false;

    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
