class Solution {
    public int Helper(int matrix[][], int i, int j, int count, int prev, int dp[][]) {
        if (i>matrix.length-1 || j>matrix[0].length-1 || i<0 || j<0 || matrix[i][j] <= prev) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];

        int up = 1;
        int down = 1;
        int left = 1;
        int right = 1;
        // if ((prev == -1 ? 0 : prev) < matrix[i][j]) {
            prev = matrix[i][j];
            up = Helper(matrix, i-1, j, count+1, prev, dp);
            down = Helper(matrix, i+1,j,count+1, prev, dp);
            right = Helper(matrix, i,j+1,count+1, prev, dp);
            left = Helper(matrix, i, j-1, count+1, prev, dp);
        // }
        dp[i][j] = 1 + Math.max(up, Math.max(down, Math.max(left, right)));
        return dp[i][j];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int ans = Integer.MIN_VALUE;
        int dp[][] = new int[matrix.length+1][matrix[0].length+1];

        for (int i=0;i<matrix.length;i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                ans = Math.max(ans, Helper(matrix, i,j,0,-1, dp));
            }
        }
        return ans;
    }
}
