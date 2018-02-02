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
        temp = new LinkedList<>();
    }

    public void enqueue(int item) {
        if (ll.isEmpty()) {
            ll.add(item);
        }
        else {
            if (item > ll.peekFirst()) {
                    temp.addLast(ll.removeFirst());
            }
            if (item <= ll.peekFirst()) {
                temp.addLast(item);
            }
            while (!temp.isEmpty()) {
                ll.addFirst(temp.removeFirst());
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