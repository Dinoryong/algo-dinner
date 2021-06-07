#include <string>
#include <vector>

using namespace std;

int answer = -1;


void dfs(int cnt,int n,int num,int number) {
	if (cnt > 8) {
		return;
	}
	if (num == number) {
		if (answer == -1 || answer > cnt)
			answer = cnt;
		return;
	}
	int nn = 0;
	for (int i = 0; i < 8; i++) {
		nn = nn * 10 + n;
		dfs(cnt + 1 + i, n, num + nn, number);
		dfs(cnt + 1 + i, n, num - nn, number);
		dfs(cnt + 1 + i, n, num * nn, number);
		dfs(cnt + 1 + i, n, num / nn, number);
	}
}

int solution(int N, int number) {
	
	dfs(0, N, 0,number);
	return answer;
}