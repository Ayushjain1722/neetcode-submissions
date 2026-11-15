class Solution {
    public int Helper(String s, String t, int i, int j, int dp[][]) {
        if (j>=t.length()) return 1;
        if (i>=s.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int way1 = 0;
        int way2 = 0;
        if (s.charAt(i) == t.charAt(j)) {
            way1 = Helper(s, t, i+1, j+1, dp);
        }
        way2 = Helper(s, t, i+1, j, dp);
        dp[i][j] = way1 + way2;
        return dp[i][j];
    }
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()+1][t.length()+1];
        for (int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        return Helper(s, t, 0,0, dp);
    }
}
