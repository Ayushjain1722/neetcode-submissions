class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i=0;i<s.length();i++) {
            // Odd length substrings
            int l = i;
            int r = i;
            while (r<s.length() && l>=0 && s.charAt(l) == s.charAt(r)) {
                ans++;
                l--;
                r++;
            }
            // Even len substrings
            l = i;
            r = i+1;
            while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                ans++;
            }
        }

        return ans;
    }
}
