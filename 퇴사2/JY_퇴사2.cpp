#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 1500005

int N;
int info[MAX][2];
int Dp[MAX];

int main() {
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);
	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> info[i][0] >> info[i][1];
	}

	int max_cost = 0;
	
	for (int day = 1; day <= N + 1; day++) {
		max_cost = max(max_cost, Dp[day]);
		int next_day = day + info[day][0];
		if (next_day > N + 1)continue;
		Dp[next_day] = max(Dp[next_day], max_cost + info[day][1]);
	}
	cout << max_cost;

	return 0;
}