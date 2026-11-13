class Solution {
    public int Helper(String s, String t, int i, int j, int dp[][]) {
        if (i > s.length()-1 || j>t.length()-1) {
            return 0;
        }
        if (dp[i][j]!=-1)
            return dp[i][j];
        int way1 = Helper(s, t, i+1, j, dp);
        int way2 = Helper(s, t, i, j+1, dp);
        int way3 = 0;
        if (s.charAt(i) == t.charAt(j)) {
            way3 = 1 + Helper(s, t, i+1,j+1, dp);
        }

        dp[i][j] = Math.max(way1, Math.max(way2, way3));
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for(int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        return Helper(text1, text2, 0,0, dp);
    }
}
