package your_code;

<<<<<<< HEAD
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
=======
import com.sun.jdi.connect.Connector;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class MyPriorityQueue {
    // Priority queue implementation.


    private ArrayList<Integer> al;


    public MyPriorityQueue() {
        // Creates new PriorityQueue with ArrayList implementation.
        al = new ArrayList<>();
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    public void enqueue(int item) {
        // Adds item to the priority queue.
        // item : integer to add.
        al.add(item);
    }
    public int dequeueMax() {
<<<<<<< HEAD
        int largest = ll.removeLast();
        return largest;
=======
        // Removes maximum value from the queue.
        // returns int value of the maximum.
        int max = al.get(0);
        int index = 0;
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) > max) {
                max = al.get(i);
                index = i;
            }
        }
        al.remove(index);
        return max;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }
}
