class Solution {
    public String longestCommonPrefix(String[] strs) {
        int wordsNum = strs.length;
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        if(strs.length==0) {
            return "";
        }
        if(strs[0].length()==0) {
            return "";
        }
        
        int count = 0;
        
        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 0; j < wordsNum; j++) {
                if(strs[0].charAt(i) == strs[j].charAt(i)){
                    count++;
                }
            }
            if(count == wordsNum) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
            count=0;
        }
        return sb.toString();
    }
}
