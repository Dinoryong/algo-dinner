#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <map>
#include <algorithm>
#include <sstream>
#include <set>
using namespace std;

typedef pair<long long, int> p;

int cnt[360000];

struct cmp {
	bool operator()(p a, p b) {
		if (a.first == b.first) {
			return a.second > b.second;
		}
		return a.first < b.first;
	}

};

string solution(string play_time, string adv_time, vector<string> logs) {
	string answer = "";

	int play, adv;

	int play_time_second = stoi(play_time.substr(6, 2));
	int play_time_minute = stoi(play_time.substr(3, 2));
	int play_time_hour = stoi(play_time.substr(0, 2));

	play = (3600 * play_time_hour) + (60 * play_time_minute) + play_time_second;
	
	int adv_time_second = stoi(adv_time.substr(6, 2));
	int adv_time_minute = stoi(adv_time.substr(3, 2));
	int adv_time_hour = stoi(adv_time.substr(0, 2));

	adv = (3600 * adv_time_hour) + (60 * adv_time_minute) + adv_time_second;

	if (play == adv) return "00:00:00";

	int s_hour, s_minute, s_second,e_hour,e_minute,e_second;

	for (string log : logs) {
		s_hour = stoi(log.substr(0, 2));
		s_minute = stoi(log.substr(3, 2));
		s_second = stoi(log.substr(6, 2));
		e_hour = stoi(log.substr(9, 2));
		e_minute = stoi(log.substr(12, 2));
		e_second = stoi(log.substr(15, 2));
		int start_time = (s_hour * 3600) + (s_minute * 60) + s_second;
		int end_time = (e_hour * 3600) + (e_minute * 60) + e_second;

		for (int i = start_time+1; i <= end_time; i++) {
			cnt[i]++;
		}
	}

	int left = 0;
	int right = adv;

	int result = 0;

	priority_queue<p, vector<p>, cmp> pq;

	while (right != play + 1) {
		long long Time = 0;
		for (int i = left+1; i <= right; i++) {
			Time += cnt[i];
		}
		pq.push({ Time, left });
		left++;
		right++;
	}

	result = pq.top().second;
	int hour = result / 3600;
	result = result % 3600;
	int minute = result / 60;
	result = result % 60;
	int second = result;

	if (hour < 10) {
		answer += "0" + to_string(hour);
	}
	else {
		answer += to_string(hour);
	}

	if (minute < 10) {
		answer += ":0" + to_string(minute);
	}
	else {
		answer += ":" + to_string(minute);
	}

	if (second < 10) {
		answer += ":0" + to_string(second);
	}
	else {
		answer += ":" + to_string(second);
	}

	return answer;
}