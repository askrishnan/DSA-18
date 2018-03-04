import java.util.Arrays;
import java.util.Collections;

public class CountingSort {

    /**
     * Use counting sort to sort positive integer array A.
     * Runtime: O(N+K)
=======
     * Use counting sort to sort non-negative integer array A.
     * Runtime: O(N)
     *
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
        // Make the array the length of the maximum element
        int max_element = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max_element) {
                max_element = A[i];
            }
        }
        int[] places_array = new int[max_element + 1];
        for (int i = 0; i < A.length; i++) {
            places_array[A[i]]++;
        }
        int place = 0;
        for (int j = 0; j < places_array.length;j++ ) {
            while (places_array[j] > 0) {
                A[place] = j;
                place++;
                places_array[j]--;
            }
        }
         // TODO
    }

}
