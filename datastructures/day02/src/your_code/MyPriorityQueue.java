package your_code;

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
    }

    public void enqueue(int item) {
        // Adds item to the priority queue.
        // item : integer to add.
        al.add(item);
    }
    public int dequeueMax() {
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
    }

}