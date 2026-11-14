class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void Helper(int nums[], int target, int i, List<Integer> arr) {
        if (target == 0)  {
            ans.add(new ArrayList<>(arr));
            return;
        }
        if (i >= nums.length || target < 0) {
            return;
        }
        arr.add(nums[i]);
        Helper(nums, target-nums[i], i, arr);
        arr.remove(arr.size()-1);
        Helper(nums, target, i+1, arr);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Helper(nums, target, 0, new ArrayList<>());
        return ans;
    }
}
