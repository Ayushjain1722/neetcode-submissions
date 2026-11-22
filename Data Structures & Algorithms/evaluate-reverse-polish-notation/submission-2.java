class Solution {
    public int calc(int n1, int n2, String operand) {
        if (operand.equals("+")) {
            return n1 + n2;
        } else if (operand.equals("-")) {
            return n1 - n2;
        } else if (operand.equals("*")) {
            return n1 * n2;
        } else if (operand.equals("/")) {
            return n1 / n2;
        } else { 
            return Integer.MIN_VALUE;
        }
    }
    public int evalRPN(String[] tokens) {
        if (tokens.length<=1)  return Integer.parseInt(tokens[0]);
        Stack<String> st = new Stack<>();
        int ans = 0;
        int i = 0;
        while (!st.isEmpty() || i==0) {
            if (i >= tokens.length) break;
            if (tokens[i].equals("+") || tokens[i].equals("-") 
            || tokens[i].equals("*") || tokens[i].equals("/")) {
                int n1 = Integer.parseInt(st.pop());
                int n2 = Integer.parseInt(st.pop());
                n1 = calc(n2, n1, tokens[i]);
                st.push(Integer.toString(n1));
            } else {
                st.push(tokens[i]);
            }
            i++;
        }

        return Integer.parseInt(st.pop());
    }
}
