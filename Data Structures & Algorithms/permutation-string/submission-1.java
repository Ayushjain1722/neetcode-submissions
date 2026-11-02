class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int l = 0;
        int r = s1.length()-1;
        int s1Freq[] = new int[26];
        int windowFreq[] = new int[26];
        for (int i=0;i<s1.length();i++) {
            s1Freq[s1.charAt(i)- 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }
        while (r < s2.length()) {
            if(Arrays.equals(s1Freq, windowFreq)){
                return true;
            }
            windowFreq[s2.charAt(l)-'a']--;
            l++;
            r++;
            if (r < s2.length())
                windowFreq[s2.charAt(r) - 'a']++;
        }

        return false;
    }
}
