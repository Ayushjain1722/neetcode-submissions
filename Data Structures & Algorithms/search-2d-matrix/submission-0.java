
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int l1 = 0;
        int r1 = matrix.length - 1;

        while (l1 <= r1) {

            int mid1 = l1 + (r1 - l1) / 2;

            if (matrix[mid1][0] <= target &&
                matrix[mid1][matrix[0].length - 1] >= target) {

                int l2 = 0;
                int r2 = matrix[0].length - 1;

                while (l2 <= r2) {

                    int mid2 = l2 + (r2 - l2) / 2;

                    if (matrix[mid1][mid2] == target) {
                        return true;
                    }
                    else if (matrix[mid1][mid2] < target) {
                        l2 = mid2 + 1;
                    }
                    else {
                        r2 = mid2 - 1;
                    }
                }

                return false;

            } else if (matrix[mid1][0] > target) {
                r1 = mid1 - 1;
            } else {
                l1 = mid1 + 1;
            }
        }

        return false;
    }
}
