class Solution {
    public boolean Helper(String s, HashSet<String> map, int sI, HashMap<Integer, Boolean> dp) {
        if (sI >= s.length()) return true;
        if (dp.containsKey(sI)) return dp.get(sI);
        for(int i=sI; i<s.length();i++) {
            if (map.contains(s.substring(sI, i+1))) {
                if (Helper(s, map, i+1, dp) ) {
                    dp.put(sI, true);
                    return true;
                }
            }
        }
        dp.put(sI, false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> map = new HashSet<>();
        for (int i =0;i<wordDict.size();i++) {
            map.add(wordDict.get(i));
        }

        HashMap<Integer, Boolean> dp = new HashMap<>();

        return Helper(s, map, 0, dp);
    }
}
