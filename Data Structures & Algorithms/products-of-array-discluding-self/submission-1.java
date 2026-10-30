class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] preProd = new int[nums.length];
        int[] postProd = new int[nums.length];

        for(int i=0;i<nums.length;i++) {
            preProd[i] = nums[i] * (i-1 >=0? preProd[i-1]:1);
            // System.out.println(preProd[i]);
        }

        for(int i=nums.length-1;i>=0;i--) {
            postProd[i] = nums[i] * (i+1<nums.length? postProd[i+1]:1);
        }

        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            int preProduct = (i-1>=0)? preProd[i-1]:1;
            int postProduct = (i+1<nums.length? postProd[i+1]:1);
            // System.out.println(i + " " + preProduct +" " + postProduct);
            ans[i] = (preProduct) * (postProduct);
        }
        return ans;
    }
}  
