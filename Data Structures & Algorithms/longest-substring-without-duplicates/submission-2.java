
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        int l = 0;
        int r = 0;
        int maxLen = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {

            char ch = s.charAt(r);

            if (map.containsKey(ch)) {
                int oldIndex = map.get(ch);
                l = Math.max(l, oldIndex + 1);
            }

            map.put(ch, r);

            maxLen = Math.max(maxLen, r - l + 1);

            r++;
        }

        return maxLen;
    }
}
