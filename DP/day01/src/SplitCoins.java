public class SplitCoins {
    // Top DOWN!
    // Subproblem: DP[i][j] = min difference between two piles
    // Guess: add value of coins[i-1]
    // Recurrence Relation: min(adding coins[i] to sum1, not adding coins[i] to sum1)
    // Memo/Recurse: DP[i][j] = Min(splitcoins(sum1+coins[i]), splitcoins(sum1))
    // Solve final: return min difference with index 0
    // runtime and space are o(n*m) where n is number of coins and m is largest sum


    public static int splitCoins(int[] coins) {
        int sum = 0;
        for (int i : coins) {
            sum += i;
        }

        int[][] dp = new int[coins.length +1][sum+1];

        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return splitCoinsRecurs(coins, 0, sum, coins.length, dp);
    }

    public static int splitCoinsRecurs(int[] coins, int s1, int sum, int i,  int[][] dp) {
        int s2 = sum - s1; // finding value of s2
        if (i == 0) {
            return Math.abs(s1-s2); // returning the difference
        }
        if (dp[i-1][s1] != -1) {
            return dp[i-1][s1]; //return an already calculated difference
        }

        dp[i-1][s1] = Math.min(splitCoinsRecurs(coins, s1+coins[i-1], sum, i-1, dp),
                splitCoinsRecurs(coins, s1, sum, i-1, dp)); //find smallest difference
        return dp[i-1][s1];
    }
}
