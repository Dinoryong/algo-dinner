#include<iostream>
#include <vector>
using namespace std;

int main() {
	vector<int> v = { 0,1,2,3,4,5,6 };
	int m;
	cin >> m;
	int len = v.size();
	int temp = 0;
	
	int idx = 0;
	int temp2 = v[idx];
	for (int i = 0; i < len; i++) {
		int val = (idx + m) % len;
		temp = v[val];
		v[val] = temp2;
		temp2 = temp;
		idx = val;
	}
	for (int i = 0; i < len; i++) {
		cout << v[i] << ' ';
	}cout << '\n';
}
