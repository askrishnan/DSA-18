package your_code;
import ADTs.StackADT;

import java.util.LinkedList;
import java.util.Stack;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
    public Stack<Integer> max_stack;


    public MyStack() {
        ll = new LinkedList<>();
        max_stack = new Stack<>();
    }


    @Override
    public void push(Integer e) {
        if (ll.size() == 0) {
            max_stack.push(e);
        }
        if (e > max_stack.peek()) {
            max_stack.push(e); }
        ll.addFirst(e);

    }

    @Override
    public Integer pop() {
        int popped_value = ll.removeFirst();
        if (popped_value == max_stack.peek()) {
            max_stack.pop();
        }
        return popped_value;
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
        // Returns maximum element of the stack.
        return max_stack.peek();
    }
}