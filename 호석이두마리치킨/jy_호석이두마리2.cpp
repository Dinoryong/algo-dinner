#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <queue>
using namespace std;

#define MAX 101

int N, M;

vector<int> road[MAX];
int Dist[MAX][MAX];

struct info {
	int sum, first, second;
};

struct cmp {
	bool operator()(info a, info b) {
		if (a.sum == b.sum) {
			if (a.first == b.first)
				return a.second > b.second;
			return a.first > b.first;
		}
		return a.sum > b.sum;
	}
};

vector<int> solution(vector<vector<int>> city) {
	vector<int> answer;
	for (auto c : city) {
		road[c[0]].push_back(c[1]);
		road[c[1]].push_back(c[0]);
	}
	
	//memset(Dist, -1, sizeof(Dist));

	for (int i = 1; i <= N; i++) {// 거리 구하기
		vector<bool> visit(MAX, false);
		queue<int> q;
		q.push(i);
		visit[i] = true;
		//Dist[i][i] = 0;
		while (!q.empty()) { 
			int start = q.front();
			int dist = Dist[i][start];
			q.pop();
			for (int r : road[start]) {
				if (visit[r])continue;
				q.push(r);
				Dist[i][r] = dist + 1;
				visit[r] = true;
			}
		}
	}

	priority_queue<info, vector<info>, cmp> pq;

	for (int i = 1; i < N; i++) { // i와 j 선택한다 치고 
		for (int j = i + 1; j <= N; j++) {
			int sum = 0;
			for (int d = 1; d <= N; d++) {
				sum += 2 * min(Dist[i][d], Dist[j][d]);
			}

			pq.push({ sum,i,j });
		}
	}

	info result = pq.top();

	answer.push_back(result.first);
	answer.push_back(result.second);
	answer.push_back(result.sum);

	return answer;
}


int main() {

	cin >> N >> M;
	vector<vector<int>> city;

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		vector<int> tmp;
		tmp.push_back(a);
		tmp.push_back(b);
		city.push_back(tmp);
	}

	vector<int> answer = solution(city);

	for (int a : answer) {
		cout << a << ' ';
	}

	return 0;
}