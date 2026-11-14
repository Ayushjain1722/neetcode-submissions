class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    // HashSet<List<Integer>> ans = new HashSet<>();
    // List<List<Integer>> finalAns = new ArrayList<>();
    public void Helper(int nums[], int target, int i, List<Integer> arr) {
        if (target == 0) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        if (i >= nums.length || target < 0)
            return;
        arr.add(nums[i]);
        Helper(nums, target - nums[i], i+1, arr);
        arr.remove(arr.size()-1);
        while (i+1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        Helper(nums, target, i+1, arr);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Helper(candidates, target, 0, new ArrayList<>());
        return ans;
    }
}
