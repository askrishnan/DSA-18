
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * TODO
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int p = i-1;
            while (p >= 0 && array[p] > key) {
                array[p + 1] = array[p];
                p--;
            }
            array[p+1] = key;
        }
        return array;
    }

}
