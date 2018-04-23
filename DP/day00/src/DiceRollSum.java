import java.util.HashMap;

public class DiceRollSum {
    /**
     * STEPS
     * 1) Define: DP[i] = number of dice rolls needed for a value of N
     * 2) Guess: Will 1, 2, 3, 4, 5, 6 get me to the value of N?
     * 3) RR: DP[i] = DP[n - 1] + DP[n - 2] + DP[n - 3] + DP[n - 4] + DP[n - 5] + DP[n - 6]
     * 4) Recursion: I recurse through each value of n, subtracting the value of the rolls and add 1 to the number of sequences when n = 0
     * 5) Solve: DP[N] is the sum of all of the sequences that result from the recursions
     *
     * RUNTIME: O(6N) turns exponential runtimes to polynomial runtimes
     * SPACE: 0(N)
     */

    public static int diceRollSumRecurs(int N, HashMap<Integer, Integer> memo) {
        // base case
        if (N < 0) {
            // returns zero if coin value makes final value negative (aka it's too big)
            return 0;
        }
        if (N == 0) {
            // adds one sequence
            return 1;
        }
        if (memo.containsKey(N)) {      // MEMOIZATION STEP
            // return previously calculated # of sequences for the n-value
            return memo.get(N);
        }
        // RECURSIVE STEP
        int DP = diceRollSumRecurs(N - 1, memo) + diceRollSumRecurs(N - 2, memo) + diceRollSumRecurs(N - 3, memo) +
                diceRollSumRecurs(N - 4, memo) + diceRollSumRecurs(N - 5, memo) + diceRollSumRecurs(N - 6, memo);
        memo.put(N, DP);                // MEMOIZATION STEP
        return DP;
    }

    public static int diceRollSum(int N){
        HashMap<Integer, Integer> memo = new HashMap<>();
        return diceRollSumRecurs(N, memo);
    }

}
