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
        return l;
    }

    public static boolean isPalindrome(Node n) {
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
    }



    public static String infixToPostfix(String s) {
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
    }

}
