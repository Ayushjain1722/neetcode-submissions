class Solution {
    public int Helper(int amount, int coins[], int i, int dp[][]){
        if (i>=coins.length || amount < 0) return 0;
        if (amount == 0) return 1;
        if (dp[i][amount] != -1)    return dp[i][amount];

        //Take more of this coin
        int take = Helper(amount - coins[i], coins, i, dp);
        int dontTake = Helper(amount, coins, i+1, dp);

        dp[i][amount] = take + dontTake;
        return dp[i][amount];
    }
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for (int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        return Helper(amount, coins, 0, dp);
    }
}
