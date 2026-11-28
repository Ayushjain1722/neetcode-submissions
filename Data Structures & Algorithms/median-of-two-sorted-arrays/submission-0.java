class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int l = 0;
        int r = nums1.length;
        while (l <= r) {
            int mid1 = l + (r-l)/2; // No of elements in left partition from smaller array
            int mid2 = ((nums1.length + nums2.length) / 2) - mid1; // Number of elements in left array from larger array
            int l1 = mid1 - 1 >= 0? nums1[mid1-1]: Integer.MIN_VALUE;
            int l2 = mid2 - 1 >= 0? nums2[mid2 -1]: Integer.MIN_VALUE;
            int r1 = mid1 < nums1.length ? nums1[mid1]: Integer.MAX_VALUE;
            int r2 = mid2 < nums2.length ? nums2[mid2]: Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                if((nums1.length + nums2.length) % 2 == 0) {
                    // System.out.println(l1 + " " + l2 + " " + r1 + " " + r2);
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2))/ 2.0;
                } else {
                    return Math.min(r1, r2);
                }
            } else if (l1 > r2) {
                r = mid1 - 1;
            } else {
                l = mid1 + 1;
            }

        }
        return 0;
    }
}
