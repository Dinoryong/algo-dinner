"""
이렇게 푸는 게 맞나 싶나하면서 풀었는데
다들 비슷하게 풀었더라
dp
"""
def answer(G):
    DP = [[[0, 0, 0] for j in range(len(G[0]))] for i in range(len(G))]
    next_milk = {0: 1, 1: 2, 2: 0}
    now_milk = 0
    DP[0][0][0] = 1
    # print(*DP, sep='\n')
    for i in range(len(G)):
        for j in range(len(G[0])):
            now = G[i][j]
            if now == 0:
                DP[i][j][0] = max(DP[i][j - 1][2] + 1, DP[i - 1][j][2] + 1)
            else:
                DP[i][j][0] = max(DP[i][j - 1][0], DP[i - 1][j][0])

            if now == 1 and DP[i][j][2] < DP[i][j][0]:
                DP[i][j][1] = max(DP[i][j - 1][0] + 1, DP[i - 1][j][0] + 1)
            else:
                DP[i][j][1] = max(DP[i][j - 1][1], DP[i - 1][j][1])

            if now == 2 and DP[i][j][0] < DP[i][j][1]:
                DP[i][j][2] = max(DP[i][j - 1][1] + 1, DP[i - 1][j][1] + 1)
            else:
                DP[i][j][2] = max(DP[i][j - 1][2], DP[i - 1][j][2])

    return max(DP[-1][-1])


import sys
input = sys.stdin.readline
n = int(input())
G = [list(map(int, input().split())) for _ in range(n)]
print(answer(G))