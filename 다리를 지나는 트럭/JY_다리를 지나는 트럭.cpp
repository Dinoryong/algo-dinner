#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    
    queue<int> q;
    
    int sum = 0;
    for(int i=0;i<truck_weights.size();){
        if(q.empty()){        
            q.push(truck_weights[i]);
            sum += truck_weights[i];
            answer++;
            i++;
        }else{
            if(q.size() == bridge_length){
                sum -= q.front();
                q.pop();
                if(sum + truck_weights[i] <= weight){
                    q.push(truck_weights[i]);
                    sum += truck_weights[i];
                    i++;
                }
                else{
                    q.push(0);
                }
                answer++;
            }else{
                if(sum + truck_weights[i] <= weight){
                    q.push(truck_weights[i]);
                    sum += truck_weights[i];
                    i++;
                }else{
                    q.push(0);
                }
                answer++;
            }
        }
        
    }
    
    return answer + bridge_length;
}