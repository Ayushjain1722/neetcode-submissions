class Solution {
    public int robHelper(int nums[], int sI, boolean flag, int dp[]) {
        if (sI >= nums.length)  return 0;
        if (flag && sI == nums.length-1) return 0;
        if(dp[sI] != -1) return dp[sI];
        int take = nums[sI] + robHelper(nums, sI+2, flag, dp);
        int dontTake = robHelper(nums,sI+1, flag, dp);

        dp[sI] = Math.max(take, dontTake);
        return dp[sI];
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            dp[i] = -1;
        }
        int firstPass = robHelper(nums, 0, true, dp);
        Arrays.fill(dp, -1);
        int secondPass = robHelper(nums, 1, false, dp);
        return Math.max(firstPass, secondPass);
    }
}
