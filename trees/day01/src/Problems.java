import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problems {

    public static int leastSum(int[] A) {
        int[] bins = new int[10];
        int first = 0, second = 0;

        for (int i = 0; i < A.length; i++) {
            bins[A[i]]++;
        }

        boolean a = true;

        for (int i = 0; i < bins.length; i++ ) {
            if (bins[i] > 0) {
                while (bins[i] > 0) {
                    if (a) {
                        first = first * 10 + i;
                    } else {
                        second = second * 10 + i;
                    }
                    a = !(a);
                    bins[i]--;
                }
            }
        }
        return first + second; }
}
