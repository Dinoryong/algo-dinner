#include <iostream>
#include <cstring>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int T;

int answer;
int player[11][11];
bool pos_chk[11]; // 포지션에 선수가 배치됬는지 확인하기 

void solve(int idx,int sum) {
	if (idx == 11) {
		answer = max(answer, sum);
		return;
	}

	for (int j = 0; j < 11; j++) {
		if (player[idx][j] != 0 && !pos_chk[j]) { // 그 포지션에 그 선수가 할당될 수 있고 그 포지션이 아직 매칭이 안됬다면 
			pos_chk[j] = true;
			solve(idx+1, sum + player[idx][j]);
			pos_chk[j] = false;
		}
	}

}


int main() {
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);
	cin >> T;


	while (T--) {
		answer = 0;
		memset(pos_chk, false, sizeof(pos_chk));
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				cin >> player[i][j];
			}
		}
		solve(0, 0);
		cout << answer << endl;
	}



	system("pause");
	return 0;
}