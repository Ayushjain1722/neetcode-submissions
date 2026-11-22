class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int results[] = new int[temperatures.length];
        int i = 1;
        while(!st.isEmpty() && i<temperatures.length) {
            int temperature = temperatures[i];
            while (!st.isEmpty() && temperature > temperatures[st.peek()]) {
                int index = st.peek();
                int len = i - index;
                st.pop();
                results[index] = len;
            }
            st.push(i);
            i++;
        }
        return results;
    }
}
