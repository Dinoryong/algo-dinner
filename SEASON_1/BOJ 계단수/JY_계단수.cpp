#include <iostream>
#include <string>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;

#define MOD 1000000000
#define MAX 101

int N, answer = 0;
int dp[MAX][10][1 << 10]; // length 와 들어간 숫자, 0~9가 들어갔는지 확인 

int solve(int length,int x,int number) { // 총 길이, 다음 추가할 숫자, 0~9 확인 

	if (length == N)
		return number == (1 << 10) - 1 ? 1 : 0;

	int& ret = dp[length][x][number];

	if (ret != -1) return ret;

	ret = 0;

	if (x - 1 >= 0)
		ret += solve(length + 1, x - 1, number | 1 << (x - 1));
	if (x + 1 < 10)
		ret += solve(length + 1, x + 1, number | 1 << (x + 1));

	ret %= MOD;
	return ret;

}

int main() {
	cin >> N;
	
	
	for (int i = 1; i <= 9; i++) {
		memset(dp, -1, sizeof(dp));
		answer += solve(1, i, 1 << i);
		answer %= MOD;
	}

	cout << answer;

	return 0;
}