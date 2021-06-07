#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <algorithm>
#include <map>
#include <unordered_map>
using namespace std;


unordered_map<int, int> alpha;
int N, K;
vector<string> words;
int answer = 0;

void solve(int idx,int cnt) {

	if (cnt == K) {
		int tmp = 0;

		for (string word : words) {
			bool flag = true;
			for (auto w : word) {
				if (!alpha[w - 'a']) {
					flag = false;
					break;
				}
			}
			if (flag) tmp++;
		}
		
		answer = max(answer, tmp);
		return;
	}

	for (int i = idx; i < 26; i++) {
		if (!alpha[i]) { // 이 부분 없어서 시간초과 계속 나옴... 
			alpha[i]++;
			solve(i + 1, cnt + 1);
			alpha[i]--;
		}
	}

}

int main() {

	cin >> N >> K;

	for (int i = 0; i < N; i++) {
		string tmp;
		cin >> tmp;
		words.push_back(tmp.substr(4,tmp.length()-8));
	}

	if (K < 5)
		cout << answer;
	else {

		alpha['a' - 'a']++;
		alpha['n' - 'a']++;
		alpha['t' - 'a']++;
		alpha['i' - 'a']++;
		alpha['c' - 'a']++;
		K -= 5;
		solve(0,0);
		cout << answer;
	}
	


	return 0;
}