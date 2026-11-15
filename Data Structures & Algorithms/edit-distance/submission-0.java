class Solution {
    public int Helper(String s, String t, int i, int j, int dp[][]) {
        if (i >= s.length())  {
            return t.length() - j;
        }
        if (j >= t.length()) return s.length() - i;
        if (dp[i][j] != -1) return dp[i][j];
        int insert = 0;
        int delete = 0;
        int replace = 0;
        insert = 1 + Helper(s, t, i, j+1, dp);
        delete = 1 + Helper(s, t, i+1, j, dp);
        replace = (s.charAt(i) == t.charAt(j) ? 0 : 1) + Helper(s, t, i+1, j+1, dp);
        dp[i][j] = Math.min(insert, Math.min(delete, replace));
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for (int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        return Helper(word1, word2, 0, 0, dp);
    }
}
