class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxTillNow = 0;
        int l = 0;
        for (int i =0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
            maxTillNow = Math.max(maxTillNow, map.get(s.charAt(i)));

            while ((i-l + 1) - maxTillNow > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, i-l+1);
        }
        return maxLen;
    }
}
