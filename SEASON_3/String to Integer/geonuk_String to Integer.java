class Solution {
    public int myAtoi(String s) {
        int result = 0, i = 0;
        boolean isPositive = true;
        
        while (i < s.length() && s.charAt(i) == ' ') i++;
        
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            isPositive = s.charAt(i) == '+' ? true: false;
            i++;
        }
        
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digital = s.charAt(i++) - '0';
            if (isPositive && result <= (Integer.MAX_VALUE - digital)/10) {
                result = result * 10 + digital;
            } else if (!isPositive && result >= (Integer.MIN_VALUE + digital)/10) {
                result = result * 10 - digital;
            } else {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }   
        return result;
    }
}