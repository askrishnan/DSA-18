import java.util.LinkedList;

public class Problems {

    static void sortNumsBetween100s(int[] A) {
        // O(W(n + k))
        // We need positive values...
        for (int i = 0; i < A.length; i++) {
            A[i] += 101;
        }
        RadixSort.radixSort(A, 10);
        for (int i = 0; i < A.length; i++) {
            A[i] -= 101;
        }
    }

    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }


    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByCharacter(String[] A, int n) {
        int buckets = 26;
        LinkedList<String>[] list_a = new LinkedList[buckets];
        for (int i = 0; i < buckets; i ++) {
            list_a[i] = new LinkedList<>();
        }
        for (String i : A) {
            int char_val = getNthCharacter(i, n);
            list_a[char_val].add(i);
        }

        int i = 0;
        for (LinkedList<String> vals : list_a) {
            while (!vals.isEmpty()) {
                A[i] = vals.poll();
                i++;
            }
        }
    }

    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
        // This is like radix sort, but different. Runtime would be O(w(n + k))
        for (int i = 0; i < stringLength; i++) {
            countingSortByCharacter(S, i);

        }
    }

    /**
     * @param A The array to count swaps in
     */

    public static int countSwaps(int[] A) {
        // TODO
        return 0;
    }

}
