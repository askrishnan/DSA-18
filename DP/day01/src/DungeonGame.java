public class DungeonGame {

    public static int minInitialHealth(int[][] map) {
        int h = map.length;
        int w = map[0].length;

        int dp[][] = new int[h][w];

        if (map[h-1][w-1] > 0) {
            dp[h-1][w-1] = 1;
        }
        else {
            dp[h-1][w-1] = Math.abs(map[h-1][w-1]) + 1;
        }

        for (int i = h-2; i >=0; i--) {
            dp[i][w-1] = Math.max(dp[i+1][w-1] - map[i][w-1], 1);
        }
        for (int j = w-2; j >=0; j--) {
            dp[h-1][j] = Math.max(dp[h-1][j+1] - map[h-1][j], 1);
        }

        for (int i=h-2; i>=0; i--)
        {
            for (int j=w-2; j>=0; j--)
            {
                // move right or move down
                int min = Math.min(DP[i+1][j], DP[i][j+1]);
                DP[i][j] = Math.max(min - map[i][j], 1);
            }
        }

        return DP[0][0];
    }
}
