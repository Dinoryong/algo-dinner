// solved by Wolfram Hwang 21/03/31
// 그냥 투포인터로 풀었는데..
// 이게 정답인것에 대한 당위성은 사실 잘 모르겠어요
// 최대 두명을 태우니, 큰것 작은것, 하나씩 태우는게 좋다는 그리디 적인 접근법을 사용했습니다.


#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(), people.end());
    int size = people.size();
    int i = 0;
    int j = size - 1;
    // 50 50 70 80
    while(i <= j){
        int sum = people[j];
        if(sum + people[i] > limit){
            answer += 1;
            j -= 1;
        }else if(sum + people[i] <= limit){
            answer += 1;
            j -= 1;
            i += 1;
        }
    }
    return answer;
}
