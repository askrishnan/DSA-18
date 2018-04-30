public class DungeonGame {
    // Bottom UP!
    // Subproblem: DP[i][j] = minInitialHealth if i,j is the starting point to end
    // Guess: down? right?
    // Recurrence Relation: Max(Min(down, right), 1)
    // Memo/Recurse: DP[i][j] = Max(Min(down, right), 1)
    // Solve final: return DP[0][0]
    // runtime and space: o(N) N=w*h

    public static int minInitialHealth(int[][] map) {
        int h = map.length;
        int w = map[0].length;

        int dp[][] = new int[h][w];

        // where Nick is!
        if (map[h-1][w-1] > 0) {
            dp[h-1][w-1] = 1;
        }
        else {
            dp[h-1][w-1] = Math.abs(map[h-1][w-1]) + 1; // if finding Nick will take away points
        }

        // healths for last column, make sure it's never less than 0
        for (int i = h-2; i >=0; i--) {
            dp[i][w-1] = Math.max(dp[i+1][w-1] - map[i][w-1], 0); // max of health - current map val vs. 0
        }

        // healths for last row, make sure it's never less than 0
        for (int j = w-2; j >=0; j--) {
            dp[h-1][j] = Math.max(dp[h-1][j+1] - map[h-1][j], 0); // max of health - current map val vs. 0
        }

        for (int i=h-2; i>=0; i--) {
            for (int j=w-2; j>=0; j--) {
                int min = Math.min(dp[i+1][j], dp[i][j+1]); // going down going right
                dp[i][j] = Math.max(min - map[i][j], 0); //where there would be more health pt
            }
        }
        return dp[0][0];
    }
}
