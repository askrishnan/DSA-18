import java.util.Arrays;

public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;
    private InsertionSort insertionSort = new InsertionSort();

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * TODO
<<<<<<< HEAD
     * Best-case runtime: O(NlogN)
     * Worst-case runtime: O(NlogN)
     * Average-case runtime: O(NlogN)
     *
     * Space-complexity: O(N)
=======
     * Best-case runtime: O(nlogn)
     * Worst-case runtime: O(nlogn)
     * Average-case runtime: O(nlogn)
     *
     * Space-complexity: O(n)
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
     */
    @Override
    public int[] sort(int[] array) {
        // TODO
        if (array.length <= INSERTION_THRESHOLD) {
<<<<<<< HEAD
            array = insertionSort.sort(array);
            return array;
        } else {

            int mid = (array.length + 1) / 2;
            int[] a = Arrays.copyOfRange(array, 0, mid);
            int[] b = Arrays.copyOfRange(array, mid, array.length);

            a = sort(a);
            b = sort(b);
            return merge(a, b);

        }
    }
=======
            InsertionSort insertion_sort = new InsertionSort();
            return insertion_sort.sort(array);
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144

        }
        int midpoint = (array.length) / 2;
        int[] a, b;
        a = Arrays.copyOfRange(array, 0, midpoint);
        b = Arrays.copyOfRange(array, midpoint, array.length);
        return merge(sort(a), sort(b));
    }
    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] a, int[] b) {
<<<<<<< HEAD
        // TODO
        int aLength = a.length;
        int bLength = b.length;
        int[] merged = new int[aLength + bLength];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < aLength && j < bLength) {
            if (a[i] <= b[j]) {
                merged[k] = a[i];
                i++;
            }
            else {
                merged[k] = b[j];
                j++;
            }
            k++;

        }
        while (i < aLength) {
            merged[k] = a[i];
            i++;
            k++;
        }
        while (j < bLength) {
            merged[k] = b[j];
            j++;
            k++;
        }
        return merged;
=======
        int i = 0, j = 0, k = 0;
        int[] merged_array = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                merged_array[k] = a[i];
                k++;
                i++;
            }
            else {
                merged_array[k] = b[j];
                j++;
                k++;
            }
        }
        // Copy in whatever is left.
        if (i < a.length) {
            while (i < a.length) {
                merged_array[k] = a[i];
                k++;
                i++;
            }
        }
        if (j < b.length) {
            while (j < b.length) {
                merged_array[k] = b[j];
                k++;
                j++;
            }
        }
        return merged_array;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

}
