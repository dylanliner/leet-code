import java.util.*;

public class RandomizedCollection {


    private HashMap<Integer, Set<Integer>> mapOfIndices = new HashMap<>();
    private ArrayList<Integer> list = new ArrayList<>();

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!mapOfIndices.containsKey(val)) {
            list.add(val);
            mapOfIndices.computeIfAbsent(val, x -> new HashSet<>()).add(list.size() - 1);
            return true;
        } else {
            list.add(val);
            mapOfIndices.computeIfAbsent(val, x -> new HashSet<>()).add(list.size() - 1);
            return false;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {

        if (mapOfIndices.containsKey(val)) {
            int lastItem = list.get(list.size() - 1);
            int swapIndex = mapOfIndices.get(val).iterator().next();
            mapOfIndices.get(val).remove(swapIndex);
            list.set(swapIndex, lastItem);

            if (mapOfIndices.get(val).size() == 0) {
                mapOfIndices.remove(val);
            }
            if (mapOfIndices.get(lastItem) != null) {
                mapOfIndices.get(lastItem).add(swapIndex);
                mapOfIndices.get(lastItem).remove(list.size() - 1);

            }

            list.remove(list.size() - 1);
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
