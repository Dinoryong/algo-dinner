class Solution {
    public int solution(String s) {
        int answer = 1001;
        String answerString = "";

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=s.length()/2+1;i++) {
            StringBuilder tempSb = new StringBuilder();
            int cnt=1;
            for(int j=0;j<s.length();) {
                if(j + i > s.length()){
                    tempSb.append(s.substring(j, s.length()));
                    break;
                }
                if(j+i+i>s.length()) {
                    tempSb.append(s.substring(j,s.length()));
                    break;
                }
                String sub = s.substring(j,j+i);
                while(true) {                    
                    j += i;                    
                    if(j+i > s.length()) {
                        break;
                    }
                    String next = s.substring(j,j+i);
                    if(!sub.equals(next)) {
                        break;
                    }
                    cnt++;                    
                }
                
                if(cnt==1) {
                    tempSb.append(sub);
                } else {
                    tempSb.append(cnt);
                    tempSb.append(sub);
                    cnt=1;
                }
            }
            if(tempSb.length()<answer) {
                answerString = tempSb.toString();
                answer=tempSb.length();
            }
        }
        return answerString.length();
    }
}
