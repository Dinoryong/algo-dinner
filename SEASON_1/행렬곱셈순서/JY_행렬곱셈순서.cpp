#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
#define MAX 501
typedef pair<int, int> p;

int N;

vector<int> matrix[MAX];
int dp[MAX][MAX];

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		int r, c;
		cin >> r >> c;
		matrix[i].push_back(r);
		matrix[i].push_back(c);
	}

	for (int l = 1; l <= N;l++) {
		for (int i = 0; i < N - l;i++) {
			int j = i + l;
			dp[i][j] = numeric_limits<int>::max();
			for (int k = i; k < j; k++) {
				dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] + (matrix[i][0] * matrix[k][1] * matrix[j][1]));
			}
		}
	}

	cout << dp[0][N-1];


	return 0;
}