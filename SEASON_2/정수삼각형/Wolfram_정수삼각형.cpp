#include <string>
#include <vector>

using namespace std;
int max(int a, int b) {
	if (a > b) {
		return a;
	}return b;
}

int solution(vector<vector<int>> triangle) {
	int answer = 0;
	vector<vector<int> > dp;
	for (int i = 0; i < triangle.size(); i++) {
		int size = triangle[i].size();
		vector<int> vp(size);
		dp.push_back(vp);
	}
	dp[0][0] = triangle[0][0];
	for (int i = 1; i < triangle.size(); i++) {
		for (int j = 0; j < triangle[i].size(); j++) {
			if (j == 0) {
				dp[i][j] = triangle[i][j] + dp[i - 1][j];
			}
			else if (j == triangle[i].size() - 1) {
				dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
			}
			else {
				dp[i][j] = triangle[i][j] + max(dp[i - 1][j - 1], dp[i - 1][j]);
			}
			if (answer < dp[i][j]) {
				answer = dp[i][j];
			}
		}
	}
	return answer;
}
