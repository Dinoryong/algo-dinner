class Solution {
    HashMap<String, Integer> dic = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)) return true;
        
        if(dic.containsKey(s)) return dic.get(s) == 1 ? true : false;
        
        for(int i=1;i<=s.length();i++){
            String temp=s.substring(0,i);
            
            if(wordDict.contains(temp) && wordBreak(s.substring(i),wordDict)){
                dic.put(s,1);
                return true;
            }
        }
        dic.put(s,0);
        return false;
    }
    
}