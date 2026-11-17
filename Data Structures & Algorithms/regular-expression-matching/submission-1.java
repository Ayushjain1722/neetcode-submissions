class Solution {
    public boolean Helper(String s, String p, int i, int j, Boolean dp[][]) {
        if (i >= s.length() && j >= p.length()) return true;
        if (j >= p.length() && i < s.length()) return false;
        if (i >= s.length() && j < p.length()) {
            while (j < p.length()) {
                if (j+1<p.length() && p.charAt(j+1) == '*') {
                    j+=2;
                } else {
                    return false;
                }
            }
            return true;
        }
        if (dp[i][j] != null) return dp[i][j];


        if (j + 1 < p.length() && p.charAt(j+1) == '*') {
            boolean skip;
            boolean take = false;
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                take = Helper(s, p, i+1, j, dp); // Match one character with room for more
            } 
            skip = dp[i][j] = Helper(s, p, i, j+2, dp); // Nothing matched
            dp[i][j] = skip || take;
            return dp[i][j];
        }

        if (i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            dp[i][j] = Helper(s, p, i+1, j+1, dp);
            return dp[i][j];
        } 
        dp[i][j] = false;
        return false;
    }
    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length()][p.length()];
        return Helper(s, p, 0,0, dp);
    }
}
