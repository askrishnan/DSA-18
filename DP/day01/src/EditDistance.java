public class EditDistance {
    // Bottom UP!
    // Subproblem: DP[i][j] = number of changes
    // Guess: replace? delete? insert? do nothing?
    // Recurrence Relation: Min(deleting, inserting, replacing, doing nothing)
    // Memo/Recurse: DP[i][j] = min(deleting, inserting, replacing)
    // Solve final: return DP[a.length][b.length]
    // Runtime + Space: O(N*m)


    public static int minEditDist(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) { //check each letter in b against a
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j==0) {
                    dp[i][j] = i;
                }
                else {
                    int delete = dp[i-1][j] + 1; // add to number of changes
                    int insert = dp[i][j-1] + 1; // add to number of changes
                    int replace;
                    if(a.charAt(i-1) == b.charAt(j-1)) {
                        replace = dp[i-1][j-1]; //don't add if they're the same letter
                    }
                    else {
                        replace = dp[i-1][j-1] + 1;
                    }
                    dp[i][j] = Math.min(delete, Math.min(insert, replace)); //find lowest number of changes
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}


