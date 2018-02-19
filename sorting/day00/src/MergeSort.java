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
     * Best-case runtime: O(NlogN)
     * Worst-case runtime: O(NlogN)
     * Average-case runtime: O(NlogN)
     *
     * Space-complexity: O(N)
     */
    @Override
    public int[] sort(int[] array) {
        // TODO
        if (array.length <= INSERTION_THRESHOLD) {
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

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] a, int[] b) {
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
    }

}
