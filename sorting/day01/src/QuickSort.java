import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    private void shuffleArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int randIndex = ThreadLocalRandom.current().nextInt(i + 1);
            swap(array, i, randIndex);
        }
    }

    /**
     * TODO
<<<<<<< HEAD
     * Best-case runtime: O(NlogN)
     * Worst-case runtime: O(N^2)
     * Average-case runtime: O(NlogN)
     * <p>
     * Space-complexity: O(N)
=======
     * Best-case runtime: O(nlogn)
     * Worst-case runtime: O(nlogn)
     * Average-case runtime: O(n^2)
     *
     * Space-complexity: O(1)
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
     */
    @Override
    public int[] sort(int[] array) {
        // TODO: Sort the array. Make sure you avoid the O(N^2) runtime worst-case
<<<<<<< HEAD
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int j = rand.nextInt(array.length);
            swap(array, i, j);
        }

=======
        shuffleArray(array);
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        quickSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * Partition the array around a pivot, then recursively sort the left and right
     * portions of the array. A test for this method is provided in `SortTest.java`
     * Optional: use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * @param lo The beginning index of the subarray being considered (inclusive)
     * @param hi The ending index of the subarray being considered (inclusive)
     */
    public void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int p = partition(a, lo, hi);
<<<<<<< HEAD
            quickSort(a, lo, p - 1);
            quickSort(a, p + 1, hi);
=======
            quickSort(a, lo, p-1);
            quickSort(a, p+1, hi);
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        }
    }


    /**
     * Given an array, choose the array[low] element as the "pivot" element.
     * Place all elements smaller than "pivot" on "pivot"'s left, and all others
     * on its right. Return the final position of "pivot" in the partitioned array.
     *
     * @param lo The beginni     * Best-case runtime: O(nlogn)
     * Worst-case runtime: O(nlogn)
     * Average-case runtime: O(nlogn)
     *
     * Space-complexity: O(1)ng index of the subarray being considered (inclusive)
     * @param hi The ending index of the subarray being considered (inclusive)
     */
    public int partition(int[] array, int lo, int hi) {
        // TODO
<<<<<<< HEAD
=======
        int pivot = array[lo];
        int index = hi;
        int swap_index = hi + 1;
        while (index > lo) {
            if (array[index] >= pivot) {
                swap_index--;
                swap(array, swap_index, index);
            }
            index--;
        }
        swap_index--;
        swap(array, lo, swap_index);
        return swap_index;
        }
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144

        while (lo < hi) {
            if (array[lo] > array[lo + 1]) {
                swap(array, lo, lo + 1);
                lo++;
            }
            else {
                swap(array, lo + 1, hi);
                hi--;
            }
        }

        return lo;
    }
}

