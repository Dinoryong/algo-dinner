class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        
        String res = strs[0];
        
        for(int i = 1 ; i < strs.length ; ++i){
            String cmp = strs[i];
            
            int j = 0;
            while(j<cmp.length() && j<res.length() && cmp.charAt(j)==res.charAt(j))
                j++;
            if(j == 0) return "";
		
		    res = cmp.substring(0,j);
        }
        
        return res;
    }
}
