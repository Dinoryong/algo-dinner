#include <string>
#include <vector>

using namespace std;

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    int answer = 0;
    vector<vector<int>> Dist(n+1,vector<int>(n+1,10000000));
    
    for(int i=1;i<=n;i++) Dist[i][i] = 0;
    
    for(auto fare : fares){
        Dist[fare[0]][fare[1]] = fare[2];
        Dist[fare[1]][fare[0]] = fare[2];
    }
    
    for(int k = 1;k<=n;k++){
        for(int i = 1;i<=n;i++){
            for(int j = 1;j <= n;j++){
                Dist[i][j] = min(Dist[i][j], Dist[i][k] + Dist[k][j]);
            }
        }
    }
    
    answer = Dist[s][a] + Dist[s][b];
    
    for(int i=1;i<=n;i++){
        answer = min(answer,Dist[s][i] + Dist[i][a] + Dist[i][b]);
    }
    
    
    return answer;
}