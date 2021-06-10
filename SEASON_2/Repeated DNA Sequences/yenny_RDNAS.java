class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        if(s.length() < 10) return list;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<=s.length() - 10; i++) {
            String parse = s.substring(i, i+10);
            if(map.containsKey(parse)) {
                map.put(parse, map.get(parse) + 1);
            } else {
                map.put(parse, 1);
            }
        }
        
        for(String key : map.keySet()) {
            if(map.get(key) >= 2) list.add(key);
        }
        
        return list;
    }
}
