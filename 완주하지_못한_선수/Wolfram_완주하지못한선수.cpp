/*
  Sovled by Wolfram Hwang
  그냥 간단한 문제에요.
  될수 있는것에서, 될수 없는 것을빼는데, 이것을 맵으로 메모이제이션 한다 생각하면 쉽습니다.
  
*/
#include <string>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    map<string, int> mp;
    for (int i = 0; i < participant.size(); i++){
        mp[participant[i]] += 1;
    }

    for(int i = 0; i < completion.size(); i++){
        mp[completion[i]] -= 1;
    }

    for(auto it = mp.begin(); it != mp.end(); it++){
        if((*it).second == 1){
            answer = (*it).first;
        }
    }

    return answer;
}
