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
        if (ll.isEmpty()) {
            ll.add(item);
        }
        else {
            temp = new LinkedList<>();
            while (!ll.isEmpty() && item > ll.peek()) {
                temp.add(ll.remove());
            }
            temp.add(item);
            if (ll.isEmpty()) {
                ll = temp;
            }
            else {
                while (!ll.isEmpty()) {
                    temp.add(ll.remove());
                }
                ll = temp;
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
