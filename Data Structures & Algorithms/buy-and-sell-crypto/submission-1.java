class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        // int postMax[] = new int[prices.length];

        // int maxSoFar = 0;
        // for (int i=prices.length-1;i>=0;i--) {
        //     maxSoFar = Math.max(prices[i], maxSoFar);
        //     postMax[i] = maxSoFar;
        // }

        // for (int i=0;i<prices.length;i++) {
        //     maxProfit = Math.max(maxProfit, postMax[i]- prices[i]);;
        // }

        // return maxProfit;
        int minSoFar = prices[0];
        for (int i=1;i<prices.length;i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
        }
        return maxProfit;
    }
}
