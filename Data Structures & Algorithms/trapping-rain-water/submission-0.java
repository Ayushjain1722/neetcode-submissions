class Solution {
    public int trap(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int lMax = arr[l];
        int rMax = arr[r];
        int totalWater = 0;
        int currentBuildingWater = 0;
        while (l <= r) {
            if (lMax <= rMax) {
                currentBuildingWater = (lMax - arr[l]) > 0? lMax - arr[l]: 0;
                lMax = Math.max(arr[l], lMax);
                l++;
                totalWater += currentBuildingWater;
            } else {
                currentBuildingWater = (rMax - arr[r]) > 0? rMax - arr[r]: 0;
                rMax = Math.max(arr[r], rMax);
                r--;
                totalWater += currentBuildingWater;
            }
        }

        return totalWater;
    }
}
