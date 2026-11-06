class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r-l) / 2;
            //Check if the left array is sorted, then take the min
            if (nums[l] <= nums[mid]) {
                ans = Math.min(ans, nums[l]);
                l = mid + 1;
            } else { 
                // If left is not sorted, then right must be sorted since there can be only one inflection point
                ans = Math.min(ans, nums[mid]);
                r = mid - 1;
            }
        }
        return ans;
    }
}
