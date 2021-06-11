class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String res = "1";
        for(int i=2; i<=n; i++) {
            res = countAndSay(res);
        }
        return res;
    }
    
    public String countAndSay(String s) {
        String res = "";
        char c = s.charAt(0);
        int cnt = 1;
        
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == c) {
                cnt++;
            } else {
                res += (Integer.toString(cnt) + c);
                c = s.charAt(i);
                cnt = 1;
            }
        }
        res += (Integer.toString(cnt) + c);
        return res;
    }
}
