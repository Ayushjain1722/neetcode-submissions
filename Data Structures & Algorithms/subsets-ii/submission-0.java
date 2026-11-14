class Solution {
    HashSet<List<Integer>> ans = new HashSet<>();
    List<List<Integer>> ans1 = new ArrayList<>();
    public void Helper(int nums[], int i, List<Integer> arr) {
        if(i >= nums.length) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[i]);
        Helper(nums, i+1, arr);
        arr.remove(arr.size()-1);
        Helper(nums, i+1, arr);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
        Helper(nums, 0, new ArrayList<>());
        for (List<Integer> arr: ans) {
            ans1.add(arr);
        }
        return ans1;
    }
}
