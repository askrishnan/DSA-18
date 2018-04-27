public class EditDistance {

    public static int minEditDist(String a, String b) {
        int i1;
        int i2;
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            i1 = i - 1;
            i2 = j - 1;
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j==0) {
                    dp[i][j] = i;
                }
                else {
                    int delete = dp[i-1][j] + 1;
                    int insert = dp[i][j-1] + 1;
                    int replace;
                    if(a.charAt(i1) == b.charAt(i2)) {
                        replace = dp[i-1][j-1];
                    }
                    else {
                        replace = dp[i-1][j-1] + 1;
                    }
                    dp[i][j] = Math.min(delete, Math.min(insert, replace));
                }
            }
        }
        return dp[a.length()][b.length()];
    }

}
