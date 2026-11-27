class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();
        for (int i=0;i<t.length();i++) {
            if(tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }
        int uniqueT = tMap.size();
        int windowT = 0;
        String ans = "";
        int len = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (tMap.containsKey(c)) {
                if(windowMap.containsKey(c)) {
                    windowMap.put(c, windowMap.get(c)+1);
                } else {
                    windowMap.put(c, 1);
                }
                if (tMap.get(c).equals(windowMap.get(c))) {
                    windowT++;
                }
            }
            // Means all characters of t with same freq is present in this window
            while(uniqueT == windowT && l<=r) {
                if (r-l+1 < len) {
                    len = r-l+1;
                    ans = s.substring(l, r+1);
                }
                char c1 = s.charAt(l);
                if (windowMap.containsKey(c1) && windowMap.get(c1) > 0) {
                    windowMap.put(c1, windowMap.get(c1)-1);
                }
                if (tMap.containsKey(c1) && windowMap.get(c1) < tMap.get(c1)) {
                    windowT--;
                }
                l++;
            }
            r++;
        }
        return ans;

    }
}
