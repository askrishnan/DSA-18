package your_code;
import ADTs.StackADT;

import java.util.LinkedList;
import java.util.Stack;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
<<<<<<< HEAD
    private LinkedList<Integer> max;

    public MyStack() {
        ll = new LinkedList<>();
        max = new LinkedList<>();
=======
    public Stack<Integer> max_stack;


    public MyStack() {
        ll = new LinkedList<>();
        max_stack = new Stack<>();
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }


    @Override
    public void push(Integer e) {
        if (ll.size() == 0) {
            max_stack.push(e);
        }
        if (e > max_stack.peek()) {
            max_stack.push(e); }
        ll.addFirst(e);
<<<<<<< HEAD
        if (max.isEmpty()) {
            max.addFirst(e);
        }
        else if (maxElement() <= e){
            max.addFirst(e);
        }
=======

>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    @Override
    public Integer pop() {
<<<<<<< HEAD
        Integer pop = ll.removeFirst();
        if (pop == maxElement()) {
            max.removeFirst();
        }
        return pop;
=======
        int popped_value = ll.removeFirst();
        if (popped_value == max_stack.peek()) {
            max_stack.pop();
        }
        return popped_value;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public Integer peek() {
        return ll.getFirst();
    }

    public Integer maxElement() {
<<<<<<< HEAD
        return max.getFirst();
=======
        // Returns maximum element of the stack.
        return max_stack.peek();
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }
}