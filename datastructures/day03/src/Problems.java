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
            for (int i = 0; i < A.length; i++) {
                if (k == 0 && listLength < finLength) {
                    l.add(A[i]);
                }
                else if (listLength == finLength) {
                    return l;
                }
                else if (A[i] <= A[i + 1] ) {
                    l.add(A[i]);
                    listLength++;
                }
                else {
                    k--;
                }
            }
        return l;
    }

    public static boolean isPalindrome(Node n) {
        // TODO: your code here
        return false;
    }

    public static String infixToPostfix(String s) {
        // TODO
        return null;
    }

}
