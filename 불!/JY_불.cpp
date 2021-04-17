#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;
#define MAX 1001
typedef pair<int, int> p;

int R, C;

char maze[MAX][MAX];
int fire_map[MAX][MAX];
vector<p> fire;
p start;

int dx[4] = {-1,0,1,0}; // up right down left
int dy[4] = {0,1,0,-1};

bool visit[MAX][MAX] = {false,};

struct info {
	int x, y, cnt; // 현재 xy 위치와 이동 횟수
};

void move_fire() {
	queue<p> q;
	for (auto f : fire) {
		q.push({ f.first,f.second });
	}

	while (!q.empty()) {
		int size = q.size();
		while (size--) {
			int x = q.front().first;
			int y = q.front().second;
			q.pop();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C)continue;
				if (maze[nx][ny] != '#') {
					if (fire_map[nx][ny] > fire_map[x][y] + 1) {
						fire_map[nx][ny] = fire_map[x][y] + 1;
						q.push({ nx,ny });
					}
				}
			}
		}
	}
}

int main() {
	cin >> R >> C;


	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> maze[i][j];
			bool fire_chk = false;
			if (maze[i][j] == 'J') {
				start = { i,j };
			}
			if (maze[i][j] == 'F') {
				fire.push_back({ i,j });
				fire_map[i][j] = 0;
				fire_chk = true;
			}
			if (!fire_chk) fire_map[i][j] = 987654321;

		}
	}


	move_fire();
	queue<info> q;

	q.push({ start.first,start.second,0 });
	visit[start.first][start.second] = true;


	while (!q.empty()) {
		int x = q.front().x;
		int y = q.front().y;
		int cnt = q.front().cnt;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
				cout << cnt + 1;
				return 0;
			}
			else {
				if (!visit[nx][ny] && maze[nx][ny] != '#') {
					if (fire_map[nx][ny] > cnt + 1) {
						visit[nx][ny] = true;
						q.push({ nx,ny,cnt + 1 });
					}
				}
			}
		}
	}

	cout << "IMPOSSIBLE";

	system("pause");
	return 0;
}