import sys

input = sys.stdin.readline

n, w = map(int, input().split())

l = [0 for _ in range(n)]
for i in range(n - 1):
    a, b = map(int, input().split())
    l[a - 1] += 1
    l[b - 1] += 1

cnt = 0
for i in l[1:]:
    if i == 1:
        cnt += 1
print(w / cnt)