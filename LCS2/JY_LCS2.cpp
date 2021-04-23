#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 1001

string A, B;

int D[MAX][MAX];

int ans_length;

int main() {
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);

	getline(cin, A);
	getline(cin, B);

	A = '0' + A;
	B = '0' + B;

	for (int i = 1; i < A.length(); i++) {
		for (int j = 1; j < B.length(); j++) {
			if (A[i] == B[j]) {
				D[i][j] = D[i - 1][j - 1] + 1;
			}
			else {
				if (D[i - 1][j] > D[i][j - 1]) {
					D[i][j] = D[i - 1][j];
				}
				else {
					D[i][j] = D[i][j - 1];
				}
			}
		}
	}
	ans_length = D[A.length() - 1][B.length() - 1];

	vector<int> LCS;

	int i = A.length() - 1;
	int j = B.length() - 1;

	while (D[i][j] != 0) {
		if (D[i][j] == D[i][j - 1])
			j--;
		else if (D[i][j] == D[i - 1][j])
			i--;
		else if (D[i][j] - 1 == D[i - 1][j - 1]) {
			LCS.push_back(i);
			i--;
			j--;
		}
	}

	cout << ans_length << endl;

	sort(LCS.begin(), LCS.end());

	for (int idx : LCS) {
		cout << A[idx];
	}
	

	return 0;
}