import java.util.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {

        List<Integer> l = new LinkedList<>();
        int index = 0;
        l.add(A[0]);
        // Go through k times. Compare the last number to the integer.
        while (k > 0  && index < A.length - 1) {
            // If the value from A is greater, remove from L.
            if (l.size() > 0 && l.get(l.size() - 1) > A[index + 1]) {
                l.remove(l.size() - 1);
                k--;
            }
            //Otherwise, preserve the value in A.
            else {
                l.add(A[index+1]);
                index++;
            }
        }
        // If there are remaining numbers, just add the rest of A.
        if (l.size() < A.length - k) {
            for (int i = index + 1; i < A.length; i++) {
                l.add(A[i]);
            }
        }
        // Similarly,trim off any necessary extraneous values.
        while (l.size() > A.length - k) {
            l.remove(l.size() - 1);
        }


        return l;
    }

    public static boolean isPalindrome(Node n) {

        if (n == null || n.next == null) {
            return true;
        }

        // Split the list in half.
        Node fast_pointer = n;
        Node slow_pointer = n;
        while (fast_pointer.next != null && slow_pointer.next != null && fast_pointer.next.next !=null) {
            fast_pointer = fast_pointer.next.next;
            slow_pointer = slow_pointer.next;
        }

        Node center = slow_pointer.next;
        Node first_reversal_pointer = null;
        Node second_reversal_pointer = null;

        first_reversal_pointer = null;
        second_reversal_pointer = center;

        while (second_reversal_pointer != null) {
            Node next_node = second_reversal_pointer.next;
            second_reversal_pointer.next = first_reversal_pointer;
            first_reversal_pointer = second_reversal_pointer;
            second_reversal_pointer = next_node;
        }

        // Compare the two halves.
        Node first_compare_pointer = first_reversal_pointer;
        Node second_compare_pointer = n;
        while (first_compare_pointer != null) {
            if (first_compare_pointer.val != second_compare_pointer.val) {
                return false;
            }
            first_compare_pointer = first_compare_pointer.next;
            second_compare_pointer = second_compare_pointer.next;
        }

        return true;
    }

    public static String infixToPostfix(String s) {
        Stack<Character> char_stack = new Stack<>();
        String result = new String();

        for (int i = 0; i < s.length(); i++ ) {
            char a = s.charAt(i);
            if (a == '(') {
                char_stack.push(a);
            }
            else if (a == ')') {
                while (char_stack.peek() != '(' && char_stack.isEmpty() == false) {
                    result += char_stack.pop();
                    result += ' ';
                }
                char_stack.pop();
            }
            else if (a == ' ') {
                continue;
            }
            else if (Character.isDigit(a)){
                result += a;
                result += ' ';
            }
            else {
                char_stack.push(a);
            }
        }
        // Empty out the rest of the stack.
        while (!char_stack.isEmpty()) {
            result += char_stack.pop();
            result += ' ';
        }
        result = result.substring(0, result.length() -1);
        return result;

    }

}
