"""
python :

이분탐색
항상 이분탐색을 떠올리자
"""
N, K = int(input()), int(input())
start, end = 1, K

while start <= end:
    mid = (start + end) // 2

    temp = 0
    for i in range(1, N + 1):
        temp += min(mid // i, N)

    if temp >= K:
        ans = mid
        end = mid - 1
    else:
        start = mid + 1
print(ans)
