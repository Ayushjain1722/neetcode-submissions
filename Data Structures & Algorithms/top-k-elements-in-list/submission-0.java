class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Brute Force: Maintain a hashmap, sort on basis of freq.  O(nlogn)
        // OR use a heap -> O(k*logn)
        HashMap<Integer, Integer> map = new HashMap<>(); 
        // Max Freq is going to be the size of the whole array
        for (int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                int currFreq = map.get(nums[i]);
                map.put(nums[i], currFreq + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        // we have a freq map ready with us
        List<List<Integer>> arr = new ArrayList<>();
        for (int i=0;i<nums.length + 1;i++) { // Since freq can be the size of array. So a bucket size == arr.size
            arr.add(new ArrayList<>());
        }

        for (Integer ele: map.keySet()) {
            int freq = map.get(ele);
            arr.get(freq).add(ele);
        }

        int ans[] = new int[k];
        int ansIndex = 0;
        for (int i=nums.length;i>=0;i--) {
            for (int j=0;j<arr.get(i).size();j++) {
                ans[ansIndex] = arr.get(i).get(j);
                ansIndex++;
                if (ansIndex >= k)
                    return ans;
            }
        }
        return ans;
    }
}
