class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // Traverse the array 
        for (int i=0;i<nums.length;i++) {
            //Check if this element is already processed in previous turn
            if (i > 0 && nums[i] == nums[i-1]) continue;

            // Else choose this element and find the doublet that will make the sum 0
            int l = i+1;
            int r = nums.length-1;
            while (l < r) {
                //Check if second element is already processed in a previous turn
                if (l > i+1 && nums[l] == nums[l-1]) {
                    l++;
                    continue;
                }
                int sum = nums[l] + nums[r] + nums[i];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[l]);
                    triplet.add(nums[r]);
                    res.add(triplet);
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
