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
<<<<<<< HEAD
        List<Integer> l = new LinkedList<>();
        int listLength = 0;
        int finLength = A.length - k;
        int index = 0;
        int lastVal = 0;


        for (int i = 0; i < A.length; i++) {
            if (k == 0 && listLength < finLength) {
                l.add(A[i]);
            } else if (listLength == finLength) {
                return l;
            } else if (A[i] <= A[i + 1]) {
                while (A[i] < lastVal && k > 0) {
                    l.remove(index);
                    index--;
                    lastVal = l.get(index);
                    listLength--;
                    k--;
                }
                l.add(A[i]);
                index = l.indexOf(A[i]);
                lastVal = A[i];
                listLength++;
            } else {
                k--;
            }
        }
=======

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


>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        return l;
    }

    public static boolean isPalindrome(Node n) {
<<<<<<< HEAD
        Node twice = n, half = n;
        Node next, head2;
        Node prev = null, prevl = null, mid = null;

        if (n != null && n.next != null) {
            while (twice != null && twice.next != null) {
                twice = twice.next.next;
                prevl = half;
                half = half.next;
            }

            // checks to see if the number of values is odd or even
            if (twice != null) {
                mid = half;
                half = half.next;
            }

            // head for the second half of the palindrome
            head2 = half;
            prevl.next = null;

            // flip the second half
            while (head2 != null) {
                next = head2.next;
                head2.next = prev;
                prev = head2;
                head2 = next;
            }
            head2 = prev;

            // seeing if the halves are equal
            Node temp1h = n;
            Node temp2h = head2;
            while (temp1h != null && temp2h != null) {
                if (temp1h.val == temp2h.val) {
                    temp1h = temp1h.next;
                    temp2h = temp2h.next;
                }
                else {
                    return false;
                }
            }
            if (temp1h == null && temp2h == null)
                return true;
            else
                return false;
        }
        else
            return true;
=======

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
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }



    public static String infixToPostfix(String s) {
<<<<<<< HEAD
        Stack<Character> stack = new Stack<>();
        String postFix = new String("");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                postFix += c;
            }
            else if ( c == '(')
                stack.push(c);
            else if (c == ' ' && stack.peek() == ' ') {
                postFix += stack.pop();
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    if (stack.peek() == ' ') {
                        stack.pop();
                    }
                    else {
                        postFix += stack.pop();
                    }
                }
                stack.pop();
            }
            else {
                    stack.push(c);
            }
        }
        return postFix;
=======
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

>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

}
