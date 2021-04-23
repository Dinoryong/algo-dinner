#include <string>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 10001

bool visit[MAX] = {false,};

bool dfs(vector<vector<string>> tickets,vector<string>& answer,string cur,int ticket_cnt){
    answer.push_back(cur);
    if(ticket_cnt == tickets.size()) return true;
    
    for(int i=0;i<tickets.size();i++){
        if(tickets[i][0] == cur && !visit[i]){
            visit[i] = true;
            if(dfs(tickets,answer,tickets[i][1],ticket_cnt+1)) return true;
            visit[i] = false;
        }
    }
    
    answer.pop_back();
    return false;
}


vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer;
    sort(tickets.begin(),tickets.end());
    dfs(tickets,answer,"ICN",0);
    return answer;
}