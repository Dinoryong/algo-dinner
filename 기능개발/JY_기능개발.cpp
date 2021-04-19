#include <string>
#include <vector>
#include <queue>
#include <map>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    map<int,int> day_cnt;
    
    int N = progresses.size();
    
    queue<int> q;
    
    for(int i=0;i<N;i++){
        int day = (100-progresses[i]) / speeds[i];
        if(((100-progresses[i]) % speeds[i]) != 0){
            day++;
        }
        q.push(day);
    }
    
    int max_num = q.front();
    int cnt = 0;
    
    while(!q.empty()){
        int num = q.front();
        q.pop();
        if(num <= max_num){
            cnt++;
        }else{
            max_num = num;
            answer.push_back(cnt);
            cnt = 1;
        }
    }
    
    answer.push_back(cnt);
    
    
    
    return answer;
}