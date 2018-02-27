import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingSort {

    /**
     * Use counting sort to sort positive integer array A.
     * Runtime: O(n + k)
     *
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {

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
    }

}
