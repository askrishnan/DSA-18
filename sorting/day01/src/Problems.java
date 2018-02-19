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
        // TODO
        PriorityQueue<Integer> before = maxPQ();
        PriorityQueue<Integer> after = minPQ();

        for (int i = 0; i<inputStream.length; i++) {
            if (i==0 || inputStream[i] < before.peek()) {
                before.offer(inputStream[i]);
            }
            else {
                after.offer(inputStream[i]);
            }

            while (before.size() > after.size() + 1) {
                after.offer(before.poll());
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
        }

        return runningMedian;
    }

}
