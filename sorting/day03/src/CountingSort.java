<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
=======
import java.util.Arrays;
import java.util.Collections;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144

public class CountingSort {

    /**
<<<<<<< HEAD
     * Use counting sort to sort positive integer array A.
<<<<<<< HEAD
     * Runtime: O(n + k)
=======
     * Use counting sort to sort non-negative integer array A.
     * Runtime: TODO
>>>>>>> 36d97f25cf2f04bab6968f6738ddb01e54578262
=======
     * Runtime: O(N+K)
=======
     * Use counting sort to sort non-negative integer array A.
     * Runtime: O(N)
=======
     * Use counting sort to sort non-negative integer array A.
     * Runtime: TODO
>>>>>>> 1c26bfec866394d2c6a63434e361921836ce41ab
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
     *
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
<<<<<<< HEAD

        // create a List to put the array values into to find the max
        List<Integer> list = new ArrayList<>(A.length);

        // place each array value into the list
        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }

        // or just write the max function
        // find the maximum element in A (need to use a list w/ Collections.max)
        int k = Collections.max(list) + 1; //add one so range is 0-k
        int[] counts = new int[k];

        // add to count every time a number appears
        for (int i = 0; i < A.length; i++) {
            counts[A[i]]++;
        }

        // replace values in A with sorted values from counts
        int i = 0;
        for (int j = 0; j < k; j++) {   // goes through each value in counts
            while (counts[j] > 0) {     // makes sure that you are adding the right num of each element
                counts[j]--;
                A[i] = j;
                i++;
            }
        }
=======
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
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

}
