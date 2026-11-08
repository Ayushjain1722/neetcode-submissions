class Solution {
    public int Helper(int[] cost, int sI, int dp[]) {
        if (sI >= cost.length) return 0;
        if (dp[sI] != -1) return dp[sI];
        int oneStep = Helper(cost, sI+1, dp);
        int twoStep = Helper(cost, sI+2, dp);
        dp[sI] = cost[sI] + Math.min(oneStep, twoStep);
        return dp[sI];
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return Math.min(Helper(cost, 0, dp), Helper(cost, 1, dp));
    }
}
