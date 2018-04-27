public class SplitCoins {

    public static int splitCoins(int[] coins) {
        int sum = 0;
        for (int i : coins) {
            sum += i;
        }

        int[][] dp = new int[coins.length][sum];

        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<DP[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return splitCoinsRecurs(coins, 0, sum, coins.length, dp);
    }

    public static int splitCoinsRecurs(int[] coins, int s1, int sum, int i,  int[][] DP) {
        int s2 = sum - s1;
        if (i == 0) {
            return sum
        }
        if (DP[i-1][sum] != -1) {
            return DP[i-1][s1];
        }

        DP[i-1][s1] = Math.min(splitCoinsRecurs(coins, s1+coins[i-1], sum, i-1, dp),
                splitCoinsRecursive(coins, s1, sum, i-1, dp));
        return dp[index-1][sum1];
    }
}
