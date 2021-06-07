#include <string>
#include <vector>

using namespace std;

int answer = 0;

void dfs(vector<int>& numbers,int target,int idx,int cal_num){
    if(idx == numbers.size()){
        if(target == cal_num)answer++;
        return;
    }
    
    dfs(numbers,target,idx+1,cal_num + numbers[idx]);
    dfs(numbers,target,idx+1,cal_num - numbers[idx]);
}

int solution(vector<int> numbers, int target) {
    
    dfs(numbers,target,0,0);
    
    return answer;
}