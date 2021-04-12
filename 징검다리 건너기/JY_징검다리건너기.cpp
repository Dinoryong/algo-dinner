#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool possible_chk(int mid,vector<int>& stones,int k){
    int cur = -1; // 시작지점 -> k내에서 움직일 수 있는지 체크할 수 있는 시작
    
    for(int i=0;i<stones.size();i++){
        if(stones[i] - mid >= 0){
            if(i - cur > k) return false;
            cur = i;
        }
    }
    
    if(stones.size() - cur > k)return false;
    return true;
}

int solution(vector<int> stones, int k) {
    int answer = 0;

    int left = *min_element(stones.begin(),stones.end());
    int right = *max_element(stones.begin(),stones.end());
    
    while(left <= right){
        int mid = (left + right) / 2;
        if(possible_chk(mid,stones,k)){
            answer = max(answer,mid);
            left = mid + 1;
        }else{
            right = mid -1;
        }
        
    }
    
    return answer;
}