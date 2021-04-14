#include <string>
#include <vector>
#include <map>
#include <unordered_map>
#include <algorithm>
using namespace std;

int solution(vector<int> a) {
    int answer = -1;
    
    unordered_map<int,int> cnt;
    
    for(int num : a){
        cnt[num]++;
    }
    
    for(int i=0;i<a.size();i++){
        if(!cnt[i])continue;
        if(cnt[i] <= answer)continue;
        int result = 0;
        for(int j=0;j<a.size()-1;j++){
            if(a[j] != i && a[j+1] != i)continue;
            if(a[j] == a[j+1])continue;
            result++;
            j++;
        }
        answer = max(answer,result);
    }
    
    return answer*2;
}