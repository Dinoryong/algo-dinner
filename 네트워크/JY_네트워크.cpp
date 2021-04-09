#include <string>
#include <vector>

using namespace std;
#define MAX 201

vector<bool> visit(MAX,false);
vector<int> network[MAX];


void dfs(int idx){
    visit[idx] = true;
    for(int next : network[idx]){
        if(visit[next])continue;
        dfs(next);
    }
}


int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for(int i=0;i<computers.size();i++){
        for(int j=0;j<computers[i].size();j++){
            if(i == j) continue;
            if(computers[i][j] == 1){
                network[i].push_back(j);
            }
        }
    }
    
    for(int i=0;i<computers.size();i++){
        if(visit[i])continue;
        dfs(i);
        answer++;
    }
    
    
    return answer;
}