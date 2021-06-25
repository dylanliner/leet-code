import java.util.*;

public class RandomizedSet {

    private HashMap<Integer, Integer> map = new HashMap<>();

    private List<Integer> list = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int rmIndex = map.get(val);
            int lastVal = list.get(list.size() - 1);
            list.set(rmIndex, lastVal);
            map.put(lastVal, rmIndex);
            map.remove(lastVal);
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
