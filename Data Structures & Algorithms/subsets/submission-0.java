class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void Helper(int nums[], int i, List<Integer> arr) {
        if (i >= nums.length) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[i]);
        Helper(nums, i+1, arr);
        arr.remove(arr.size()-1);
        Helper(nums, i+1, arr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        Helper(nums, 0, new ArrayList<>());
        return ans;
    }
}
