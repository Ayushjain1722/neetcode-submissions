class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = -1;
        for (int i =0;i<piles.length;i++) {
            r = Math.max(r, piles[i]);
        }
        int ans = r;
        while (l <= r) {
            int mid = l + (r-l)/2;
            int hours = 0;
            for (int i=0;i<piles.length;i++) {
                hours += Math.ceil((double)piles[i]/mid);
            }
            if (hours <= h) {
                r = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
