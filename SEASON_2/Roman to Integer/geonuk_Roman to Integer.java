class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0 ; i < s.length() - 1 ; ++i){
            int a = getValue(s.charAt(i));
            int b = getValue(s.charAt(i+1));
        
            if(a >= b) res += a;
            else if(a < b) res -= a;
        }
        res += getValue(s.charAt(s.length() - 1)); 
        return res;
    }
    
    public int getValue(char c){
        if(c=='I') return 1;
        else if(c=='V') return 5;
        else if(c=='X') return 10;
        else if(c=='L') return 50;
        else if(c=='C') return 100;
        else if(c=='D') return 500;
        else return 1000;
    }
}