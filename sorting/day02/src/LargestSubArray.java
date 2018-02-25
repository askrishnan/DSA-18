import java.util.HashMap;

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
    }
}
