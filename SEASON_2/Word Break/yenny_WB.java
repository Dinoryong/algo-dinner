class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
		boolean[] b = new boolean[s.length() + 1];
		b[0] = true;
		
		for(String str : wordDict) {
			set.add(str);
		}
		
		for(int i=1; i<=s.length(); i++) {
			for(int j=0; j<i; j++) {
				if(b[j] && set.contains(s.substring(j, i))) {
					b[i] = true;
					break;
				}
			}
		}
        
        return b[s.length()];
    }
}
