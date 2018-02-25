import java.util.Arrays;

public class TripleSum {
    // Runtime is O(n^2)
    // Space complexity is O(1)

    static int tripleSum(int arr[], int sum) {
        // Sort the array.
        Arrays.sort(arr);
        int start = 0, end = 0, count = 0;
        // Go through checking for when the sum is sum and increment count.
        for (int i = 0; i < arr.length  - 2; i++) {
            start = i + 1;
            end = arr.length - 1;
            while (start < end) {
                if (arr[start] + arr[end] + arr[i] == sum) {
                    start++;
                    end--;
                    count++;
                }
                else if (arr[start] + arr[end] + arr[i] < sum) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }
        return count;


    }
}
