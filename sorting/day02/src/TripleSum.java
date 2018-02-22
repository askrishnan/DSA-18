import java.util.Arrays;

public class TripleSum {

    static int tripleSum(int arr[], int sum) {
        Arrays.sort(arr);
        int start = 0, end = 0, count = 0;

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
