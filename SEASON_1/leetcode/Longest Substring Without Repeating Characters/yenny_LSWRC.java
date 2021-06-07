class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        
        String text = "";
        int max_len = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(text.indexOf(s.charAt(i)) == -1) {
                // 현재 누적된 문자열에 동일한 문자가 없을 경우, 문자를 더함
                text += Character.toString(s.charAt(i));
            } else {
                // 현재 누적된 문자열에 동일한 문자가 있을 경우, 위치를 찾아 문자열을 자름
                // 문자열을 자른 후 새로운 문자를 더함
                text = text.substring(text.indexOf(s.charAt(i)) + 1, text.length());
                text += Character.toString(s.charAt(i));
            }
            max_len = Math.max(max_len, text.length());
        }
        return max_len;
    }
}
