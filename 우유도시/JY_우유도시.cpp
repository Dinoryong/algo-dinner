//#include <iostream>
//#include <vector>
//#include <queue>
//using namespace std;
//
//#define MAX 1001
//
//int N;
//int answer = -1;
//
//int dx[2] = {0,1}; // 동 남
//int dy[2] = {1,0};
//
//int milk[MAX][MAX];
//int dp[MAX][MAX][4];
//
//int dfs(int x,int y,int eat) { // eat는 현 시점에 마실 수 있는 우유 0은 딸기 1은 초코 2는 바나나 
//
//	int& ret = dp[x][y][eat+1];
//
//	if (ret != -1)return ret;
//	ret = 0;
//
//	for (int i = 0; i < 2; i++) {
//		int nx = x + dx[i];
//		int ny = y + dy[i];
//		if (nx < 0 || nx >= N || ny < 0 || ny >= N)continue;
//
//		if (milk[nx][ny] == (eat + 1) % 3) ret = max(ret, dfs(nx, ny, (eat + 1) % 3) + 1); // 현재 위치 먹고 다음으로 넘어갈 경우 
//		ret = max(ret, dfs(nx, ny, eat)); // 안먹고 넘어갈 경우 또는 어처피 못마시는 경우 
//	}
//	return ret;
//}
//
//int main() {
//
//	cin >> N;
//
//	for (int i = 0; i < N; i++) {
//		for (int j = 0; j < N; j++) {
//			cin >> milk[i][j];
//		}
//	}
//
//	memset(dp, -1, sizeof(dp));
//
//	if(milk[0][0] == 0)	cout << dfs(0, 0, 0) + 1;
//	else cout << dfs(0, 0, -1);
//
//	system("pause");
//	return 0;
//}


#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

#define MAX 1001

int N, answer = 0;

int milk[MAX][MAX];
int dp[MAX][MAX][3]; // x,y 위치에서 0,1,2 중 하나 우유를 마시면서 최대로 마신 우유 갯수 

int dx[2] = {1,0};
int dy[2] = {0,1};

int main() {
	ios::sync_with_stdio(false);
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> milk[i][j];
		}
	}

	for (int x = 0; x < N; x++) {
		for (int y = 0; y < N; y++) {
			if (milk[x][y] == 0) // 그 위치에서 시작할 경우 (맨 처음 시작인지 아닌지 체크) 
				dp[x][y][0] = max(dp[x][y][0], 1);
			for (int i = 0; i < 2; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)continue;

				for (int k = 0; k < 3; k++) {
					int next = milk[nx][ny];
					if (dp[x][y][k] != 0 && (k + 1) % 3 == next) { // 다음 위치 우유를 마실수 있을 경우 
						dp[nx][ny][next] = max(dp[nx][ny][next], dp[x][y][k]+1); // 안마실경우와 마실경우 체크 
					}
					else {
						dp[nx][ny][k] = max(dp[nx][ny][k], dp[x][y][k]);
					}
				}

			}

		}
	}



	for (int i = 0; i < 3; i++) {
		answer = max(answer, dp[N - 1][N - 1][i]);
	}
	cout << answer;

	system("pause");
	return 0;
}