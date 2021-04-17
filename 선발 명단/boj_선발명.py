"""
python : 비트마스킹, enumerate

dfs
완전탐색
"""
import sys

T = int(sys.stdin.readline())
visited = [0 for _ in range(11)]


def dfs(cIdx, cCost, members):
    global answer
    if cIdx > 10:
        answer = max(answer, cCost)
        return

    for i, cost in enumerate(members[cIdx]):
        if cost and not visited[i]:
            visited[i] = 1
            dfs(cIdx + 1, cCost + cost, members)
            visited[i] = 0


while T:
    answer = 0
    members = [list(map(int, sys.stdin.readline().split())) for _ in range(11)]
    dfs(0, 0, members)
    print(answer)
    T -= 1
