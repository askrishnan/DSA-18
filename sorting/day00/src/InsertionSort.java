
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * TODO
<<<<<<< HEAD
     * Best-case runtime: O(N^2)
=======
     * Best-case runtime: O(N)
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
     * Worst-case runtime: O(N^2)
     * Average-case runtime: O(N^2)
     *
     * Space-complexity: O(1)
     */
    @Override
    public int[] sort(int[] array) {
<<<<<<< HEAD
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int p = i-1;
            while (p >= 0 && array[p] > key) {
                array[p + 1] = array[p];
                p--;
            }
            array[p+1] = key;
=======
        // TODO
        for (int i = 1; i < array.length ; i++) {
            for (int j = 0; j <= i; j++) {
                if (array[j] > array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

            }
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        }
        return array;
    }

}
