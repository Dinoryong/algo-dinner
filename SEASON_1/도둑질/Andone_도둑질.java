class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        if(money.length==3) {
            answer = Math.max(money[0]+money[2],money[1]);
            return answer;
        }
        int[] dp = new int[money.length];
        int[] dp2 = new int[money.length];

        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = money[2] + dp[0];
        
        for(int i = 3; i<money.length-1;i++) {
            dp[i] = Math.max(money[i]+dp[i-3],money[i]+dp[i-2]);
        }
        
        for(int item : dp) {
            answer = Math.max(answer, item);
        }
        
        dp2[1] = money[1];
        dp2[2] = money[2];
        dp2[3] = money[3] + dp2[1];
        
        for(int i = 4; i<money.length;i++) {
            dp2[i] = Math.max(money[i]+dp2[i-3],money[i]+dp2[i-2]);
        }
        
        for(int item : dp2) {
            answer = Math.max(answer, item);
        }
        
        return answer;
    }
}