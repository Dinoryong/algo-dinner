#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

#define MAX 101
#define INF 987654321
//const int INF = (int)1e9;

int M, N; // 도시, 도로

int road[MAX][MAX];
int Dist[MAX][MAX];

int solve(int x,int y) {
	int distance = 0;
	for (int i = 1; i <= N; i++)
		distance += min(Dist[x][i], Dist[y][i]);
	return distance;
}

int main() {
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;

		road[a][b] = road[b][a] = 1;
	}

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (i == j) continue;
			else if (road[i][j] == 1) Dist[i][j] = road[i][j];
			else Dist[i][j] = INF;
		}
	}

	for (int k = 1; k <= N; k++) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				Dist[i][j] = min(Dist[i][j], Dist[i][k] + Dist[k][j]);
			}
		}
	}

	int x, y, answer = INF;
	for (int i = 1; i <= N; i++)
		for (int j = i + 1; j <= N; j++) {
			int dist = solve(i, j);
			if (answer > dist) {
				x = i, y = j;
				answer = dist;
			}
		}

	cout << x << ' ' << y << ' '<< answer * 2;
	return 0;
}