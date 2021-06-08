class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        
        int res = 0;
        for(String key : map.keySet()) {
            if(s.indexOf(key) != -1) {
                res += map.get(key);
                s = s.replace(key, "");
            }
        }
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case 'I': res += 1; break;
                case 'V': res += 5; break;
                case 'X': res += 10; break;
                case 'L': res += 50; break;
                case 'C': res += 100; break;
                case 'D': res += 500; break;
                case 'M': res += 1000; break;
                default: break;
            }
        }
        
        return res;
    }
}
