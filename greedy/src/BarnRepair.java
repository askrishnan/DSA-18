import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BarnRepair {
    public static int solve(int M, int[] occupied) {
        ArrayList<Integer> gaps = new ArrayList<>();

        Arrays.sort(occupied);

        int stalls = occupied.length;

        for (int i = 1; i < stalls; i++) {
            int gap = occupied[i] - occupied[i-1];

            if (gap > 1) {
                gaps.add(gap-1);
            }
        }

        Collections.sort(gaps);
        int boards = gaps.size() + 1;

        while (boards > M) {
            stalls += gaps.remove(0);
            boards--;
        }
        return stalls;
    }
}