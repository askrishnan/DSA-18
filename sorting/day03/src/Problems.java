import java.util.LinkedList;

public class Problems {

    static void sortNumsBetween100s(int[] A) {
<<<<<<< HEAD
        for(int i=0; i<A.length; i++){
            A[i] = A[i] + 100;
        }
        CountingSort.countingSort(A);
        for(int i=0; i<A.length; i++){
            A[i] = A[i] - 100;
        }

=======
        // O(W(n + k))
        // We need positive values...
        for (int i = 0; i < A.length; i++) {
            A[i] += 101;
        }
        RadixSort.radixSort(A, 10);
        for (int i = 0; i < A.length; i++) {
            A[i] -= 101;
        }
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
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
<<<<<<< HEAD
        LinkedList<String>[] list = new LinkedList[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new LinkedList<>();
        }
        for (String i : A) {
            list[getNthCharacter(i, n)].add(i);
        }
        int j = 0;
        for (LinkedList<String> list2: list) {
            if (list2.size() != 0) {
                for (String s : list2) {
                    A[j] = s;
                    j++;
                }
            }
        }

=======
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
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
<<<<<<< HEAD
        // TODO
        for (int i = 0; i < stringLength; i++)
        {
            countingSortByCharacter(S, i);
=======
        // This is like radix sort, but different. Runtime would be O(w(n + k))
        for (int i = 0; i < stringLength; i++) {
            countingSortByCharacter(S, i);

>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
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
