#include <string>
#include <vector>

using namespace std;
vector<int> solution(vector<int> prices) {
	vector<int> answer;

	int cnt = 0;

	for (int i = 0; i < prices.size(); i++) {
		cnt = 0;
		for (int j = i+1; j < prices.size(); j++) {
			if (prices[i] <= prices[j]) {
				cnt++;
			}
			else {
				cnt++;
				break;
			}
		}
		answer.push_back(cnt);
	}


	return answer;
}