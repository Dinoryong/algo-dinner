#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>
using namespace std;

#define MAX 1000001

int N;

vector<int> tree[MAX];
bool visit[MAX];
int dp[MAX][2];

void dfs(int cur) {
	visit[cur] = true;
	dp[cur][0] = 0;
	dp[cur][1] = 1;
	for (int next : tree[cur]) {
		if (visit[next]) continue;
		dfs(next);
		dp[cur][0] += dp[next][1]; // 내가 얼리어답터가 아니면 내 모든 친구는 얼리여야한다. 
		dp[cur][1] += min(dp[next][0], dp[next][1]);// 내가 얼리면 내 친구는 둘중 하나여도 무방
	}
}

int main() {
	
	cin >> N;

	for (int i = 0; i < N-1; i++) {
		int a, b;
		cin >> a >> b;
		tree[a].push_back(b);
		tree[b].push_back(a);
	}

	dfs(1);
	
	cout << min(dp[1][0], dp[1][1]);

	return 0;
}