#include <string>
#include <vector>
#include <queue>
#include <map>
#include <algorithm>
using namespace std;
#define MAX 300001

vector<int> Emp[MAX];
int Dp[MAX][2]; // 0은 불참 1은 참석

void dfs(vector<int>& sales,int idx){
    
    if(Emp[idx].size() == 0){
        Dp[idx][0] = 0;
        Dp[idx][1] = sales[idx-1];
        return;
    }
    for(int next : Emp[idx]){
        dfs(sales,next);
    }
    
    int sum_child = 0;
    int min_cost = 987654321;
    bool chk = false; // 만족하는 k가 있을경우 확인용
    for(int child : Emp[idx]){
        sum_child += min(Dp[child][0],Dp[child][1]);
        if(Dp[child][0] >= Dp[child][1]) chk = true; // 만족하는 k가 하나라도 있다면
        min_cost = min(min_cost,Dp[child][1] - Dp[child][0]); // -로 가면 위 조건에 해당하는 애가 하나라도 있기 때문에 참석시키지 않아도 되는 거고 그게 아니라면 한명을 참석시켜야 하는데 합치는 도중 가장 적은애가 들어가는게 베스트
    }
    
    Dp[idx][1] = sum_child + sales[idx-1];
    if(chk) Dp[idx][0] = sum_child;
    else Dp[idx][0] = sum_child + min_cost;
}


int solution(vector<int> sales, vector<vector<int>> links) {
    int answer = 0;
    
    for(auto link : links){
        int parent = link[0];
        int child = link[1];
        Emp[parent].push_back(child);
    }
    
    dfs(sales,1);
    
    answer = min(Dp[1][0] , Dp[1][1]);
    
    return answer;
}