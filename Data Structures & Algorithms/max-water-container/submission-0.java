class Solution {
    public int maxArea(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int maxArea = Integer.MIN_VALUE;
        while (l<r) {
            int area = (r-l) * Math.min(nums[r], nums[l]);
            maxArea = Math.max(maxArea, area);
            if (nums[l] <= nums[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
