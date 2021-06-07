// Solved by Wolfram Hwang
// 그냥.. 스택문제입니다..
// 더이상 설명할게 없..
#include <stdbool.h>
#include <stdlib.h>

int* solution(int prices[], size_t prices_len) {
    int* answer = (int*)malloc(sizeof(int)*prices_len);
    int a = 0;
    int c = 0;
    int j = 0;


    for(int i = 0;i < prices_len; i++){
        a = prices[i];
        j = i + 1;
        while(j != prices_len){
            if(a <= prices[j]){
                c++;
                j++;
            }else{
                c++;
                break;
            } 
        }
        answer[i] = c;
        c = 0;
    }

    return answer;
}
