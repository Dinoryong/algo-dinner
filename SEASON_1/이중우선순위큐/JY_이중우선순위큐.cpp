#include <string>
#include <vector>
#include <queue>
#include <deque>
#include <algorithm>
using namespace std;

vector<int> solution(vector<string> operations) {
	vector<int> answer;

	deque<int> dq;

	for (int i = 0; i < operations.size(); i++) {
		char oper;
		int number;

		oper = operations[i][0];

		number = stoi(operations[i].substr(2));

		if (oper == 'I') {
			dq.push_back(number);
			sort(dq.begin(), dq.end());
		}
		else {

			if (dq.empty())continue;
			if (number == 1)
				dq.pop_back();
			else
				dq.pop_front();
		}
	}

	if (dq.empty()) {
		answer.push_back(0);
		answer.push_back(0);
	}
	else {
		answer.push_back(dq.back());
		answer.push_back(dq.front());
	}

	return answer;
}