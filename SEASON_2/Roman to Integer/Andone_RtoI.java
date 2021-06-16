class Solution {
    public int solve (char v) {
        if(v == 'I')
            return 1;
        else if(v == 'V')
            return 5;
        else if(v == 'X')
            return 10;
        else if(v == 'L')
            return 50;
        else if(v == 'C')
            return 100;
        else if(v == 'D')
            return 500;
        else
            return 1000;
    }
    
    public int romanToInt(String s) {
        char[] arrays = s.toCharArray();
        int answer = 0;
        
        if(arrays.length == 1) {
            return solve(arrays[0]);
        }
        
        for(int i = arrays.length-1;i>0;i--) {
            if(solve(arrays[i-1])==solve(arrays[i])) {
                answer += solve(arrays[i]);
            } else if(solve(arrays[i-1])<solve(arrays[i])) {
                answer += (solve(arrays[i])-solve(arrays[i-1]));
                i--;
            } else {
                answer += solve(arrays[i]);
            }
            if(i == 1) {
                answer += solve(arrays[0]);
            }
        }
        
        return answer;
    }
}