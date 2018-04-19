import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problems {

    private static PriorityQueue<Integer> minPQ() {
        return new PriorityQueue<>(11);
    }

    private static PriorityQueue<Integer> maxPQ() {
        return new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private static double getMedian(List<Integer> A) {
        double median = (double) A.get(A.size() / 2);
        if (A.size() % 2 == 0)
            median = (median + A.get(A.size() / 2 - 1)) / 2.0;
        return median;
    }

    // Runtime of this algorithm is O(N^2). Sad! We provide it here for testing purposes
    public static double[] runningMedianReallySlow(int[] A) {
        double[] out = new double[A.length];
        List<Integer> seen = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            while (j < seen.size() && seen.get(j) < A[i])
                j++;
            seen.add(j, A[i]);
            out[i] = getMedian(seen);
        }
        return out;
    }


    /**
     *
     * @param inputStream an input stream of integers
     * @return the median of the stream, after each element has been added
     */
    public static double[] runningMedian(int[] inputStream) {

        double[] runningMedian = new double[inputStream.length];
<<<<<<< HEAD
        // TODO
        PriorityQueue<Integer> before = maxPQ();
        PriorityQueue<Integer> after = minPQ();

        for (int i = 0; i<inputStream.length; i++) { //O(N)
            if (i==0 || inputStream[i] < before.peek()) {
                before.offer(inputStream[i]);
            }
            else {
                after.offer(inputStream[i]);
            }

            while (before.size() > after.size() + 1) {
                after.offer(before.poll()); //O(1)
            }
            while (after.size() > before.size() + 1) {
                before.offer(after.poll());
            }

            if (after.size() == before.size()) {
                runningMedian[i] = (double) (before.peek() + after.peek())/2;
            }
            else if (before.size() > after.size()) {
                runningMedian[i] = before.peek();
            }
            else if (after.size() > before.size()) {
                runningMedian[i] = after.peek();
            }
=======
        if (inputStream.length == 0) {
            return runningMedian;
        }
        // Make two priority queues.
        PriorityQueue<Integer> min_vals = minPQ();
        PriorityQueue<Integer> max_vals = maxPQ();

        for (int i=0; i < inputStream.length; i++) {
            // Odd and even cases are sad, but I'm not sure how else to deal...
            if (i % 2 == 0) {
                if (max_vals.isEmpty() || inputStream[i] < min_vals.peek()) {
                    max_vals.offer(inputStream[i]);
                }
                else {
                    min_vals.offer(inputStream[i]);
                }
                if (max_vals.size() >= min_vals.size()) {
                    runningMedian[i] = max_vals.peek();
                }
                else {
                    runningMedian[i] = min_vals.peek();
                }
            }
            else {
                if (max_vals.size() > min_vals.size()) {
                    if (inputStream[i] < max_vals.peek()) {
                        min_vals.offer(max_vals.poll());
                        max_vals.offer(inputStream[i]);
                    }
                    else {
                        min_vals.offer(inputStream[i]);
                    }
                }
                else {
                    if (inputStream[i] > min_vals.peek()) {
                        max_vals.offer(min_vals.poll());
                        min_vals.offer(inputStream[i]);
                    }
                    else {
                        max_vals.offer(inputStream[i]);
                    }
                }
            runningMedian[i] = (((double) max_vals.peek()) + min_vals.peek())/2 ;
            }

>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        }

        return runningMedian;
    }

}
