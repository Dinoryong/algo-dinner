//?? 3번 테케만 틀리는데 이유를 모르겠습니다..

class Solution {
    public int solution(String s) {
        int answer = 1001;
        String answerString = "";

        StringBuilder sb = new StringBuilder();

//        if(s.length()==1) {
//            answerString="a";
//            return answerString.length();
//        }

        for(int i=1;i<=s.length()/2+1;i++) {
            StringBuilder tempSb = new StringBuilder();
            int cnt=1;
            for(int j=0;j<s.length();) {
                if(j+i+i>s.length()) {
                    tempSb.append(s.substring(j,s.length()));
                    break;
                }
                String sub = s.substring(j,j+i);
                String next = s.substring(j+i,j+i+i);

                while(sub.equals(next)) {
                    j=j+i;
                    if(j+i>s.length()) {
                        break;
                    }
                    cnt++;
                    next = s.substring(j,j+i);
                }

                if(cnt==1) {
                    tempSb.append(sub);
                    j=j+i;
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