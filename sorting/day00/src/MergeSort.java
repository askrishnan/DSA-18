import java.util.Arrays;

public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * TODO
     * Best-case runtime: O(nlogn)
     * Worst-case runtime: O(nlogn)
     * Average-case runtime: O(nlogn)
     *
     * Space-complexity: O(n)
     */
    @Override
    public int[] sort(int[] array) {
        // TODO
        if (array.length <= INSERTION_THRESHOLD) {
            InsertionSort insertion_sort = new InsertionSort();
            return insertion_sort.sort(array);

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
    }

}
