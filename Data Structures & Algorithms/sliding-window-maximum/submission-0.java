class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for(int i=0;i<k;i++) {
            pq.add(nums[i]);
        }
        int ptr = 0;
        ans[ptr++] = pq.peek();
        for (int i=k;i<nums.length;i++) {
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
            ans[ptr++] = pq.peek();
        }
        return ans;
    }
}
