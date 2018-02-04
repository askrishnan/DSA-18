package your_code;

import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {
    private LinkedList<Integer> ll;
    private LinkedList<Integer> temp;

    public MyPriorityQueue() {
        ll = new LinkedList<>();
    }

    public void enqueue(int item) {
        if (ll.isEmpty() || item >= ll.peekLast()) {
            ll.add(item);
        }
        else {
            temp = new LinkedList<>();
            while (item < ll.peekLast()) {
                temp.add(ll.removeLast());
            }
            ll.add(item);
            while (!temp.isEmpty()) {
                ll.add(temp.removeLast());
            }
        }
    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
        int largest = ll.removeLast();
        return largest;
    }
}
