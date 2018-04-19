import java.util.Arrays;

public class TripleSum {
    // Runtime is O(n^2)
    // Space complexity is O(1)

    static int tripleSum(int arr[], int sum) {
<<<<<<< HEAD
        int length = arr.length;
        int num1, num2;
        int triples = 0;

        Arrays.sort(arr, 0, length);

        for (int i = 0; i < length - 2; i++) {
            num1 = i + 1;
            num2 = length - 1;
            while (num1 < num2) {
                if (arr[i] + arr[num1] + arr[num2] == sum) {
                    triples++;
                    num1++;
                    num2--;
                }
                else if (arr[i] + arr[num1] + arr[num2] < sum) {
                    num1++;
                }
                else {
                    num2--;
                }
            }
        }
        return triples;
=======
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


>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }
}
