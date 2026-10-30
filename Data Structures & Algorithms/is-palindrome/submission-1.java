class Solution {
    public boolean isAlphaNumeric(char ch){
        if ((ch >= 'A' && ch <='Z') || 
            (ch >= 'a' && ch <='z') || 
            (ch >= '0' && ch <='9'))
            return true;
        return false; 
    }
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l >=0 && r <s.length() && l <= r) {
            if(!isAlphaNumeric(s.charAt(l))) {
                l++;
                continue;
            }
            if (!isAlphaNumeric(s.charAt(r))) {
                r--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
