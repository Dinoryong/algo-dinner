"""
python :

1 <= N <= 1,500,000

7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
"""
# 틀린 풀이
# import sys
#
# n = int(sys.stdin.readline())
# t = [0 for _ in range(n)]
# p = [0 for _ in range(n)]
#
# max_res = [0 for _ in range(n + 1)]
#
# for i in range(n):
#     t[i], p[i] = map(int, sys.stdin.readline().split())
#
# for i in range(n):
#     if (i + t[i]) < (n+1):
#         max_res[i + t[i]] = max(max_res[i] + p[i], max_res[i + t[i]])
#         max_res[i + 1] = max(max_res[i + 1], max_res[i])
#
# print(max(max_res))


""""""
#
import sys
input = sys.stdin.readline
n = int(input().strip())
day = []
for i in range(n):
    day.append(list(map(int, input().strip().split())))

dp = [0] * 1500001

for i in range(n):
    if (i + day[i][0]) <= n:
        dp[i + day[i][0]] = max(dp[i + day[i][0]], dp[i] + day[i][1])
    dp[i + 1] = max(dp[i + 1], dp[i])

print(dp[n])

"""
시간 초과
"""
n = int(input())
temp = []
max_res = 0
t, p = [], []
for i in range(n):
    ti, pi = map(int, input().split())
    t.append(ti)
    p.append(pi)

M = 0
dp = [0] * (n + 1)
for i in range(n):
    M = max(M, dp[i])
    if (i + t[i]) > n:
        continue
    dp[i + t[i]] = max(M + p[i], dp[i + t[i]])

print(max(dp))