class Solution {
    public boolean Helper(int nums[], int i, Boolean dp[]) {
        if (i >= nums.length -1) return true;
        if (dp[i] != null) return dp[i];
        int jumps = nums[i];
        for(int jump=1;jump<=jumps;jump++) {
            if (Helper(nums, i+jump, dp)){
                dp[i] = true;
                return true;
            }
        }
        dp[i] = false;
        return dp[i];
    }
    public boolean canJump(int[] nums) {
        // Boolean dp[] = new Boolean[nums.length+1];
        // return Helper(nums, 0, dp);

        int maxReach = 0;
        for (int i=0;i<nums.length;i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i+nums[i]);
            if (maxReach >= nums.length-1) return true;
        }
        return maxReach >= nums.length-1;
    }
}
