#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<queue>

using namespace std;

vector<int> v[500001];
bool visit[500001];
double cnt[500001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, w;
	cin >> n >> w;
	for (int i = 0; i < n - 1; i++) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	queue<pair<int, double> > q;
	q.push({ 1, (double)w });
	visit[1] = true;
	cnt[1] = (double)w;
	while (!q.empty()) {
		int now = q.front().first;
		double weight = q.front().second;
		q.pop();
		if (now == 1) {
			cnt[now] = -1;
			weight /= (double)(v[now].size());
			for (int i = 0; i < v[now].size(); i++) {
				int next = v[now][i];
				if (visit[next] == true) continue;
				visit[next] = true;
				cnt[next] = weight;
				q.push({ next, weight });
			}
		}
		else {
			if (v[now].size() > 1) {
				cnt[now] = -1;
				weight /= (double)(v[now].size() - 1);
				for (int i = 0; i < v[now].size(); i++) {
					int next = v[now][i];
					if (visit[next] == true) continue;
					visit[next] = true;
					cnt[next] = weight;
					q.push({ next, weight });
				}
			}
		}
		
		
	}
	double sum = 0;
	int count = 0;
	for (int i = 1; i <= n; i++) {
		if (cnt[i] < 0) continue;
		count++;
		sum += cnt[i];
	}
	double ret = sum / (double)count;
	cout.precision(6); cout << fixed << ret << '\n';
	return 0;
}
