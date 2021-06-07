#include <string>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 300001

vector<int> tree[MAX];
bool visit[MAX] = {false,};
long long answer = 0;
vector<int> num;

long long dfs(int cur){
    long long sum = num[cur];
    visit[cur] = true;
    for(int next : tree[cur]){
        if(visit[next]) continue;
        long long child = dfs(next);
        answer += abs(child);
        sum += child;
    }
    return sum;
}

long long solution(vector<int> a, vector<vector<int>> edges) {
    num = a;
    for(auto edge : edges){
        tree[edge[0]].push_back(edge[1]);
        tree[edge[1]].push_back(edge[0]);
    }
    
    
    return dfs(0) == 0 ? answer : -1;
}