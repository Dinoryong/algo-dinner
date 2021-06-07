#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

#define MAX 20001

int solution(int n, vector<vector<int>> edge) {
	int answer = 0; 
    
    vector<int> graph[MAX];
    bool visit[MAX] = {false,};
    vector<int> Dist(MAX,0);
    queue<int> q;
    
    for(auto ed : edge){
        graph[ed[0]].push_back(ed[1]);
        graph[ed[1]].push_back(ed[0]);
    }
    
    q.push(1);
    visit[1] = true;
    
    while(!q.empty()){
        int s_node = q.front();
        q.pop();
        for(int g : graph[s_node]){
            if(visit[g]) continue;
            visit[g] = true;
            Dist[g] = Dist[s_node] + 1;
            q.push(g);
        }
    }
    
    sort(Dist.begin(),Dist.end(),greater<int>());
    
    int max_num = Dist[0];
    
    for(int d : Dist){
        if(max_num != d) break;
        answer++;
    }
    
	return answer;
}