class Solution {
    public String getSignature(String s) {
        int freq[] = new int[26];
        for (int i=0;i<s.length();i++) {
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<freq.length;i++) {
            sb.append(i+'a').append(freq[i]);
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i=0;i<strs.length;i++) {
            String signature = getSignature(strs[i]);
            if(map.containsKey(signature)) {
                if(map.get(signature) == null){
                    List<String> arr = new ArrayList<>();
                    arr.add(strs[i]);
                    map.put(signature, arr);
                } else {
                    List<String> arr = map.get(signature);
                    arr.add(strs[i]);
                    map.put(signature, arr);
                }
            } else {
                List<String> arr = new ArrayList<>();
                    arr.add(strs[i]);
                map.put(signature, arr);
            }
        }

        //Iterate over HashMap and put all the arrays in the final list
        List<List<String>> ans = new ArrayList<>();
        for (String s: map.keySet()) {
            ans.add(map.get(s));
        }

        return ans;
    }
}
