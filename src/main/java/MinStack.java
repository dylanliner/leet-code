import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinStack {

   PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    List<Integer> list = new ArrayList<>();

    public MinStack() {

    }

    public void push(int val) {
        minHeap.add(val);
        list.add(val);
    }

    public void pop() {
        minHeap.remove(list.get(list.size() - 1));
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return minHeap.peek();
    }
}
