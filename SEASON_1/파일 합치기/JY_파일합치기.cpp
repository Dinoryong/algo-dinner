#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

#define MAX 501

int T;

int dp[MAX][MAX];

int main() {

	cin >> T;

	while (T--) {
		int K;
		cin >> K;
		vector<int> sum(K + 1, 0);
		for (int i = 1; i <= K; i++) {
			int file_size;
			cin >> file_size;
			sum[i] = sum[i - 1] + file_size;
		}

		for (int i = 1; i < K; i++) {
			for (int j = 1; j <= K - i; j++) {
				dp[j][i + j] = 987654321;
				for (int k = j; k < i + j; k++) {
					dp[j][i + j] = min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j]);
				}
				dp[j][i + j] += sum[i + j] - sum[j - 1];
			}
		}
		cout << dp[1][K] << endl;
	}


	return 0;
}