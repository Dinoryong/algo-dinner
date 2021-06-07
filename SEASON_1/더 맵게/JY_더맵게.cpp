#include <string>
#include <vector>
#include <queue>
#include <deque>
#include <algorithm>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int,vector<int>,greater<int>> pq;
    
    sort(scoville.begin(),scoville.end());
    for(int s : scoville){
        pq.push(s);
    }
    
    bool success = false;
    while(1){
        if(pq.size() == 1) {
            if(pq.top() < K)
                break;
            else{
                success = true;
                break;
            }
        }
        int first = pq.top();
        pq.pop();
        
        if(first >= K) {
            success = true;
            break;
        }
        int second = pq.top();
        pq.pop();
        
        int scoville_value = first + (second * 2);
        pq.push(scoville_value);
        answer++;
    }
    
    if(!success) answer = -1;
    
    
    return answer;
}