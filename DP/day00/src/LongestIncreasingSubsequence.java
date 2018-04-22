public class LongestIncreasingSubsequence {
    /**
     * STEPS
     * 1) Define: DP[i] = length of subsequence
     * 2) Guess: Which values will create the longest increasing subsequence?
     * 3) RR: DP[i] = DP[orev longest subsequence that works] + 1
     * 4) Memoization: I hold on to the lengths of increasing subsequences, changing them when I find a longer one
     * 5) Solve: DP[i] is the length of the longest subsequence
     */
    // Runtime: O(N^2)
    // Space: O(N)
    public static int LIS(int[] A) {
        int longest = -1;
        int[] DP = new int[A.length];

        // starting at the end to make sure the values after i are greater
        for (int i = A.length - 1; i >= 0; i--) {
            // works through values after A[i]
            for (int j = i + 1; j < A.length; j++) {
                // checks for increasing-ness
                if (A[i] < A[j]) {
                    // uses lengths of preexisting increasing subsequences (chooses the longer one)
                    if (DP[i] < DP[j] + 1) {
                        DP[i] = DP[j] + 1;
                    }
                }
            }
            // if subsequence is longer than current longest subsequence, change value
            if (DP[i] > longest) {
                longest = DP[i];
            }
        }

        // adds one to account for first pair
        return longest + 1;
    }
}