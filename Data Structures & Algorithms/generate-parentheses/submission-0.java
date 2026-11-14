class Solution {
    List<String> ans = new ArrayList<>();
    public void Helper(int n1, int n2, String s) {
        if (n1 == 0 && n2 == 0){
            ans.add(s.toString());
            return;
        }
        if (n1 > 0) {
            Helper(n1-1, n2, s + "(");
        }
        if (n2 > n1){
            Helper(n1, n2-1, s+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        Helper(n-1, n, "(");
        return ans;
    }
}
