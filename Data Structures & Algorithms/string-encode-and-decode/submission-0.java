class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++) {
            String s = strs.get(i);
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i<str.length()) {
            //read the size of string to be read
            StringBuilder sb = new StringBuilder();
            while (str.charAt(i) != '#') {
                sb.append(str.charAt(i));
                i++;
            }
            int strSize = Integer.parseInt(sb.toString());
            i++;
            StringBuilder sb2 = new StringBuilder();
            int j = 0;
            while (j<strSize) {
                sb2.append(str.charAt(i));
                i++;
                j++;
            }
            decoded.add(sb2.toString());
        }
        return decoded;
    }
}
