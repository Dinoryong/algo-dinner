class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int gap = (numRows - 1) << 1;
        StringBuilder str = new StringBuilder();
        
        for(int r = 0 ; r < numRows ; ++r){
            for(int i = r ; i < s.length() ; i+=gap){
                str.append(s.charAt(i));
                
                if(r > 0 && r < numRows - 1 && i + gap - 2 * r < s.length()){
                    str.append(s.charAt(i + gap - 2 * r));
                }
            }
        }
        
        return str.toString();
    }
}