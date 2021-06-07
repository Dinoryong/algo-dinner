#include <vector>
#include <queue>
using namespace std;

typedef pair<int, int> p;
#define MAX 100

vector<p> dist[MAX];
bool visit[MAX] = { false };

int solution(int n, vector<vector<int>> costs) {
	int answer = 0;

	for (int i = 0; i < costs.size(); i++) {
		dist[costs[i][0]].push_back({ costs[i][2],costs[i][1] });
		dist[costs[i][1]].push_back({ costs[i][2],costs[i][0] });
	}
    
    priority_queue<p, vector<p>, greater<p>> pq;
	visit[0] = true;
	for (int i = 0; i < dist[0].size(); i++) {
		pq.push(dist[0][i]);
	}

	while (!pq.empty()) {
		p node = pq.top();
		pq.pop();
		if (!visit[node.second]) {
			visit[node.second] = true;
			answer += node.first;
			for (int i = 0; i < dist[node.second].size(); i++) {
				pq.push(dist[node.second][i]);
			}
		}
	}
    
	return answer;
}