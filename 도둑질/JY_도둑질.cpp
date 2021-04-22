#include <string>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 1000001

int dp[MAX];

int solution(vector<int> money) {
    int answer = 0;
    int N = money.size();
    dp[0] = money[0]; // 첫번째 집을 털때 
    dp[1] = max(money[0],money[1]);
    for(int i=2;i<N;i++){
        dp[i] = max(dp[i-1],dp[i-2] + money[i]);
    }
    
    answer = dp[N-2];
    
    dp[0] = 0;
    dp[1] = money[1];
    for(int i=2;i<N;i++){
        dp[i] = max(dp[i-1],dp[i-2] + money[i]);
    }
    
    answer = max(answer,dp[N-1]);
    
    return answer;
}