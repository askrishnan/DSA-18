public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Check children, and swap with larger child if necessary.
    // Corrects the position of element indexed i by sinking it.
    // Use either recursion or a loop to then sink the child
    public void sink(int i) {
<<<<<<< HEAD
        int leftChild = leftChild(i);
        int rightChild = rightChild(i);
        int childIndex = i;
        if (size > leftChild) {
            if (heap[leftChild] > heap[childIndex]) {
                childIndex = leftChild;
            }
        }
        if (size > rightChild) {
            if (heap[rightChild] > heap[childIndex]) {
                childIndex = rightChild;
            }
        }
        if (childIndex != i) {
            int temp = heap[i];
            heap[i] = heap[childIndex];
            heap[childIndex] = temp;
            sink(childIndex);
=======
        int child_index = i;
        if (size > leftChild(i)) {
            if(heap[leftChild(i)] > heap[i]) {
                child_index = leftChild(i);
            }
        }
        if (size > rightChild(i)) {
            if (heap[rightChild(i)] > heap[child_index]) {
                child_index = rightChild(i);
            }
        }
        if (child_index != i) {
            swap(heap, child_index, i);
            sink(child_index);
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;

        for (int i=this.size / 2 - 1; i>=0; i--) {
            sink(i);
        }
    }

    /**
     * Best-case runtime: O(nlogn)
     * Worst-case runtime: O(nlogn)
     * Average-case runtime: O(nlogn)
     *
<<<<<<< HEAD
     * Space-complexity:O(1)
=======
     * Space-complexity: O(1)
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
     */
    @Override
    public int[] sort(int[] array) {
        heapify(array);
        size = array.length;
        for (int i=size-1; i>0; i--) {
<<<<<<< HEAD
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
=======
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
            size--;
            sink(0);
        }

        return array;
    }
}
