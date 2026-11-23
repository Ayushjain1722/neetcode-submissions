class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<heights.length;i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int index = st.pop();
                int h = heights[index];
                int leftBoundary = (!st.isEmpty()) ? st.peek(): -1;
                int w = i - leftBoundary -1;
                maxArea = Math.max(maxArea, h * w);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int index = st.pop();
            int h = heights[index];
            int leftBoundary = (!st.isEmpty()) ? st.peek(): -1;
            int w = heights.length - leftBoundary - 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }
}
