class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) {
            return 0;
        }
        if(needle.length() == haystack.length()) {
            if(needle.equals(haystack)) {
                return 0;
            } else {
                return -1;
            }
        }
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}