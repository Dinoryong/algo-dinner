class Solution {
    public List<String> findRepeatedDnaSequences(String s) {        
        Set<String> set = new HashSet<>();
        Set<String> answerSet = new HashSet<>();
        
        for(int i=0;i<s.length()-9;i++) {
            if(!set.add(s.substring(i,i+10))){
                answerSet.add(s.substring(i,i+10));
            }
        }
        ArrayList<String> list = new ArrayList<>(answerSet);
        
        return list;
    }
}