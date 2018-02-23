import java.util.Arrays;

public class TripleSum {

    static int tripleSum(int arr[], int sum) {
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
    }
}
