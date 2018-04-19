import java.util.HashMap;
<<<<<<< HEAD

public class LargestSubArray {
    static int[] largestSubarray(int[] nums) {

        int sum = 0;
        int length = nums.length;
        int[] sums = new int[length];

        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                sum -= 1;
            }
            else {
                sum += 1;
            }
            sums[i] = sum;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int finArrSize = 0;
        int endInd = 0;
        for (int i = 0; i < length; i++) {
            if (sums[i]==0) {
                finArrSize = i + 1;
                endInd = i;
            }
            else if (map.containsKey(sums[i])) {
                if (finArrSize < i - map.get(sums[i])) {
                    finArrSize = i - map.get(sums[i]);
                    endInd = i;
                }
            }
            else {
                map.put(sums[i], i);
            }
        }

        int finStart = endInd - finArrSize + 1;
        int[] finRange = {finStart, endInd};
        return finRange;
=======

// Runtime is O(N)

public class LargestSubArray {
    static int[] largestSubarray(int[] nums) {
        // Following the hint, and treating 0s as negative 1.
        // Create a hashmap that has all of the sums and their indices
        HashMap<Integer, Integer> sum_indices = new HashMap<Integer, Integer>();
        int sum = 0;
        // Convert 0's to -1's
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] * 2 - 1;
            sum_indices.put(sum, i);
        }
        // Go through array, looking for sums
        sum = 0;
        int total_size = 0;
        int[] total = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            // If we find an array larger than the remaining portion, we're good to go.
            if (nums.length - i <= total_size ) {
                break;
            }
            // Otherwise, just check if we've found a larger piece
            int largest_index = sum_indices.get(sum);
            if (largest_index - i > total_size) {
                total_size = largest_index - i;
                total[0] = i;
                total[1] = largest_index;
            }
            sum += nums[i] * 2 - 1;
        }
        return total;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }
}
