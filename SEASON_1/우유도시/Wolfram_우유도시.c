//
//  Solving.c
//  BOJ_Algorithm
//
//  Created by 황지웅 on 2021/04/14.
//


#include<stdio.h>
#define max(a, b) (((a) > (b)) ? (a) : (b))

int n;
int map[1000][1000];
int dp[1000][1000][2];
int memo[1000][1000][2];
int main(){
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            scanf("%d", &map[i][j]);
            memo[i][j][0] = -1;
            memo[i][j][1] = -1;
        }
    }
    if(map[0][0] == 0) {
        memo[0][0][1] = map[0][0];
        dp[0][0][1] = 1;
    }else{
        memo[0][0][1] = -1;
        dp[0][0][1] = 0;
    }
    memo[0][0][0] = -1;
    dp[0][0][0] = 0;
    for(int i = 1; i < n; i++){
        int diff1 =  map[0][i] - memo[0][i - 1][1];
        if (diff1 == 1 || diff1 == -2 ){
            if( dp[0][i][1] < dp[0][i - 1][1] + 1){
                dp[0][i][1] = dp[0][i-1][1] + 1;
                memo[0][i][1] = map[0][i];
            }
        }
        int diff2 = map[0][i] - memo[0][i - 1][0];
        if( diff2 == 1 || diff2 == -2 ){
            if (dp[0][i][1] < dp[0][i-1][0] + 1 ){
                dp[0][i][1] = dp[0][i-1][0] + 1;
                memo[0][i][1] = map[0][i];
            }
        }
        //쓰지 않는 상황은?
        dp[0][i][0] = max(dp[0][i-1][0], dp[0][i-1][1]);
        memo[0][i][0] = dp[0][i - 1][0] > dp[0][i - 1][1] ? memo[0][i - 1][0] : memo[0][i-1][1];
    }
    
    for(int i = 1; i < n; i++){
        // 지금 것을 쓰기 위해선, 이전 것이 차이가 양수 1이 나거나, -2 가 나야함
        // 쓰는 상황을 가정해본다.
        int diff1 =  map[i][0] - memo[i - 1][0][1];
        if( diff1 == 1 || diff1 == -2 ){
            if( dp[i][0][1] < dp[i-1][0][1] + 1){
                dp[i][0][1] = dp[i-1][0][1] + 1;
                memo[i][0][1] = map[i][0];
            }
        }
        int diff2 = map[i][0] - memo[i - 1][0][0];
        if( diff2 == 1 || diff2 == -2 ){
            if( dp[i][0][1] < dp[i-1][0][0] + 1) {
                dp[i][0][1] = dp[i-1][0][0] + 1;
                memo[i][0][1] = map[i][0];
            }
        }
        //쓰지 않는 상황은?
        dp[i][0][0] = max(dp[i-1][0][0], dp[i-1][0][1]);
        memo[i][0][0] = dp[i-1][0][0] > dp[i-1][0][1] ? memo[i-1][0][0] : memo[i-1][0][1];
    }
    for (int i = 1; i < n; i++){
        for(int j = 1; j < n; j++){
            int diff1 =  map[i][j] - memo[i - 1][j][1];
            if( diff1 == 1 || diff1 == -2 ){
                if( dp[i][j][1] < dp[i-1][j][1] + 1){
                    dp[i][j][1] = dp[i-1][j][1] + 1;
                    memo[i][j][1] = map[i][j];
                }
            }
            int diff2 = map[i][j] - memo[i - 1][j][0];
            if( diff2 == 1 || diff2 == -2 ){
                if( dp[i][j][1] < dp[i-1][j][0] + 1 ){
                    dp[i][j][1] = dp[i-1][j][0] + 1;
                    memo[i][j][1] = map[i][j];
                }
            }
            //쓰지 않는 상황은?
            //
            int diff3 =  map[i][j] - memo[i][j - 1][1];
            if (diff3 == 1 || diff3 == -2 ){
                if( dp[i][j][1] < dp[i][j - 1][1] + 1){
                    dp[i][j][1] = dp[i][j - 1][1] + 1;
                    memo[i][j][1] = map[i][j];
                }
            }
            int diff4 = map[i][j] - memo[i][j - 1][0];
            if( diff4 == 1 || diff4 == -2 ){
                if( dp[i][j][1] < dp[i][j - 1][0] + 1 ){
                    dp[i][j][1] = dp[i][j - 1][0] + 1;
                    memo[i][j][1] = map[i][j];
                }
            }
            //쓰지 않는 상황은?
            dp[i][j][0] = max(max(dp[i][j - 1][0], dp[i][j - 1][1]) ,max(dp[i-1][j][0], dp[i-1][j][1]));
            int x = i;
            int y = j - 1;
            int z = 0;
            if( dp[x][y][z] < dp[i][j-1][1] ){
                x = i; y = j - 1; z = 1;
            }
            if( dp[x][y][z] < dp[i-1][j][0]) {
                x = i-1; y = j; z = 0;
            }
            if( dp[x][y][z] < dp[i-1][j][1] ){
                x = i-1;y=j;z=1;
            }
            memo[i][j][0] = memo[x][y][z];
        }
    }
    printf("%d\n", max(dp[n-1][n-1][0], dp[n-1][n-1][1]));
}
