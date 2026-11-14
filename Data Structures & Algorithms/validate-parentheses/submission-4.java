class Solution {
    public boolean isStarting(char ch) {
        if (ch == '[' || ch == '(' || ch == '{') {
            return true;
        }
        return false;
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if (s.isEmpty())    return true;
        if (s.length()%2!=0) return false;
        int i = 0;
        while (i<s.length()) {
            if (isStarting(s.charAt(i))) {
                st.push(s.charAt(i));
            } else {
                char curr = s.charAt(i);
                if (st.isEmpty()) return false;
                if (curr == ']' && !st.isEmpty() && st.peek()!='[') return false;
                if (curr == ')' && !st.isEmpty() && st.peek()!='(') return false;
                if (curr == '}' && !st.isEmpty() && st.peek()!='{') return false;
                if (!st.isEmpty())
                    st.pop();
            }
            i++;
        }
        if (!st.isEmpty()) return false;
        return true;
    }
}
