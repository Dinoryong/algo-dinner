#include <string>
#include <vector>
#include <algorithm>
using namespace std;

long long solution(int n, vector<int> times) {
    
    sort(times.begin(),times.end());
    
    long long left = 1;
    long long right = (long long)times[times.size()-1]*n;
    long long answer = right;
    while(left <= right){
        long long mid = (left + right) >> 1;
        long long cnt = 0;
        for(int i=0;i<times.size();i++)
            cnt += mid / (long long)times[i];
        if(cnt < n)
            left = mid + 1;
        else{
            if(answer >= mid)
                answer = mid;
            right = mid - 1;
        }
    }
    
    return answer;
}