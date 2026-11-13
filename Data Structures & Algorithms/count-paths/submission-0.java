class Solution {
    public int Helper(int m, int n, int i, int j, int dp[][]) {
        if (i==m-1 && j==n-1) {
            return 1;
        }
        if (i <0 || j<0 || i>m-1 || j>n-1)  return 0;
        if(dp[i][j] != -1)  return dp[i][j];
        int right = Helper(m, n, i+1, j, dp);
        int down = Helper(m,n,i,j+1, dp);
        dp[i][j] = right + down;
        return dp[i][j];

    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        return Helper(m, n, 0, 0, dp);
    }
}
