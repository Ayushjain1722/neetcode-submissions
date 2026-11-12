class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            // Iterate through array's each element
            //Check if we need to append this element or replace it in our array
            int l = 0;
            int r = dp.size(); // Imp one size higher upper bound since the left pointer can come up until here.
            while (l < r) {
                int mid = l + (r-l)/2;
                if (dp.get(mid) >= nums[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l == dp.size()) {
                dp.add(nums[i]);
            } else {
                dp.set(l, nums[i]);
            }
        }
        return dp.size();
    }
}
