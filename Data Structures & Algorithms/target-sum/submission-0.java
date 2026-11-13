class Solution {
    public int Helper(int nums[], int target, int sum, int i, HashMap<String, Integer> dp) {
        if (i > nums.length-1) 
            return target == sum ? 1 : 0;
        String key = i + "," + sum;
        if (dp.containsKey(key))
            return dp.get(key);

        int add = Helper(nums, target, sum + nums[i], i+1,dp);
        int sub = Helper(nums, target, sum - nums[i], i+1,dp);

        dp.put(key,add + sub);
        return dp.get(key);

    }
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int i=0;i<nums.length;i++) {
            totalSum += nums[i];
        }
        // int dp[][] = new int[nums.length][totalSum+1];
        // for (int i=0;i<dp.length;i++) {
        //     Arrays.fill(dp[i], Integer.MIN_VALUE);
        // }
        HashMap<String, Integer> dp = new HashMap<>();
        return Helper(nums, target, 0, 0, dp);
    }
}
