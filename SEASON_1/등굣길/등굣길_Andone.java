class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[m][n];
        
        for(int i = 0; i< m ;i++) {
            for(int j = 0; j<n;j++) {
                dp[i][j]=0;
            }
        }
        
        
        for(int i = 0; i < puddles.length;i++) {
            dp[puddles[i][0]-1][puddles[i][1]-1]=-1;
        }
        
        dp[0][0]=1;
        
        for(int i = 0; i< m;i++) {
            for(int j = 0; j<n; j++) {
                if(dp[i][j]==-1) {
                    dp[i][j]=0;
                    continue;
                }
                if(i!=0)
                    dp[i][j] += dp[i-1][j]%1000000007;
                if(j!=0)
                    dp[i][j] += dp[i][j-1]%1000000007;
            }
        }
        
        return dp[m-1][n-1]%1000000007;
    }
}