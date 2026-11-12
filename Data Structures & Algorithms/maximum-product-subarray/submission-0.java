class Solution {

    public int Helper(int nums[], int sI) {
        if(sI >= nums.length) return 1;
        int product = 1;
        int take = Helper(nums, sI+1) * product * nums[sI];
        int dontTake = Helper(nums, sI+1) * product;
        return Math.max(take, dontTake);
    }
    public int maxProduct(int[] nums) {
        int prefixProd = 1;
        int postProd = 1;
        int ans = Integer.MIN_VALUE;

        for (int i=0;i<nums.length;i++) {
            if (nums[i] == 0) {
                prefixProd = 1;
                postProd = 1;
                ans = Math.max(ans, 0);
                continue;
            }
            prefixProd *= nums[i];
            postProd *= nums[nums.length-1-i];

            ans = Math.max(ans, Math.max(prefixProd, postProd));
        }

        return ans;
    }
}
