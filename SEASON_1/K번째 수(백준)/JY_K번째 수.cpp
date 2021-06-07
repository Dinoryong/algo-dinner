#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
using namespace std;

long long N, K;
long long answer = 0;

int main() {
	cin >> N >> K;

	long long left = 1, right = K;

	while (left <= right) {
		long long mid = (left + right) >> 1;
		long long cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += min(N, mid / i);
		}

		if (cnt >= K) {
			right = mid - 1;
			answer = mid;
		}
		else
			left = mid + 1;
	}
	cout << answer;

	system("pause");
	return 0;
}