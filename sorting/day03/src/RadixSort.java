import java.util.LinkedList;

import static java.lang.Math.abs;

public class RadixSort {

    /**
     * @param n the digit number, 0 is least significant
     * @return
     * If K < NlogN
     */
    private static int getNthDigit(int number, int base, int n) {
        return number / ((int) Math.pow(base, n)) % base;
    }


    /**
     * Use counting sort to sort the integer array according to a digit
     *
     * @param b The base used in radix sort
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByDigit(int[] A, int b, int n) {
        LinkedList<Integer>[] L = new LinkedList[b];
        for (int i = 0; i < b; i++)
            L[i] = new LinkedList<>();
        for (int i : A) {
<<<<<<< HEAD
            L[getNthDigit(i, b, n)].add(i);

        }
        int j = 0; // index in A to place numbers
        for (LinkedList<Integer> list : L) {
            while (list.size() > 0) {
                A[j] = list.pop();
                j++;

=======
            // Sort by digits.
            int digit = abs(getNthDigit(i, b, n));
            L[digit].add(i);
        }
        int j = 0; // index in A to place numbers
        for (LinkedList<Integer> vals : L) {
            // Replace all of te values;
            while (!vals.isEmpty()) {
                A[j] = vals.poll();
                j++;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
            }
        }
    }

    /**
<<<<<<< HEAD
     * Runtime: O(W(n+b))
     * TODO: Express your runtime in terms of n, b, and w
     * super long if word length is greater than logN
=======
     * Runtime: O(w(n + b))
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
     * n: length of array
     * w: word length of integers A in base b (equal to log base b of k (log_b k) )
     *
     * @param b The base to use for radix sort
     */
    static void radixSort(int[] A, int b) {
        // Calculate the upper-bound for numbers in A
        int k = A[0] + 1;
        for (int i = 1; i < A.length; i++)
            k = (A[i] + 1 > k) ? A[i] + 1 : k;
        int w = (int) Math.ceil(Math.log(k) / Math.log(b)); // w = log base b of k, word length of numbers
<<<<<<< HEAD
        // TODO: Perform radix sort
        for (int i = 0; i < w; i++) {
=======
        for (int i = 0; i <= w; i++) {
            // Just do counting sort for each individual piece.
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
            countingSortByDigit(A, b, i);
        }
    }

}
