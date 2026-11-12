class Solution {
    int totalSum = 0;
    public boolean Helper(int nums[], int sum, int i, Boolean [][] dp) {
        if (sum == totalSum/2) return true;
        if (i >= nums.length) return false;
        if (dp[i][sum] != null) return dp[i][sum];
        boolean take = Helper(nums, sum - nums[i], i+1, dp);
        boolean dontTake = Helper(nums, sum, i+1, dp);
        dp[i][sum] = take || dontTake;
        return dp[i][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
        }
        if (sum %2 != 0) return false;
        totalSum = sum;
        // HashMap<Integer, Boolean> map = new HashMap<>();
        Boolean dp[][] = new Boolean[nums.length][sum+1];
        return Helper(nums, sum, 0, dp);
    }
}
