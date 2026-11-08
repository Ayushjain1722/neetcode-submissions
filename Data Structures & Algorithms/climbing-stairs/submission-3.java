class Solution {
    public int Helper(int n, int dp[]) {
        if (dp[n] != -1)    return dp[n];
        if (n <= 0)  return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int oneStepAtATime = Helper(n-1, dp);
        int twoStepAtATime = Helper(n-2, dp);

        dp[n] = oneStepAtATime + twoStepAtATime;
        return dp[n];
    }
    public int climbStairs(int n) { 
        int dp[] = new int[n+1];
        // Arrays.fill(dp, -1);
        // return Helper(n, dp);
        if (n <= 0)  return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3;i<dp.length;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
