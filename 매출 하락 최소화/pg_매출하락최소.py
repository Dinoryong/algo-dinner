"""
[트리 dp]
다시 보기
풀이는 다른 풀이 참고
dp table ?
python => functools


카카오 7번 - 트리 dp
dp 접근법이 좋음

2 <= sales배열 크기 <= 300,000  :  각 직원들(쎄오 포함)의 하루평균 매출액
0 <= sale <= 10,000

links 배열 크기 = sales 배열 크기 - 1
[a 팀장 직원번호, b 관리하는 팀원의 직원번호] a=/= b
직원번호 1 => ceo   /   b =/= 1
links 배열 은 트리 구조

# 루트 노드로부터 DFS 로 내려가면서,
# 각각의 노드가 루트가 되는 서브트리에 대한 최적해
children_sum[i] = sum(min(dp[k][0], dp[k][1]))
dp[i][1] = sales[i] + children_sum

#
dp[i][0] = children_sum

#
dp[i][0] = children_sum + min(dp[k][1] - dp[k][0])

# 1번 루트 노드 (CEO)가 참석할 경우
dp[i][1]

# 1번 루트 노드 (CEO)가 불참할 경우
dp[i][0]
"""
def solution(sales, links):
    arr = [[] for _ in range(len(sales))]
    for a, b in links:
        arr[a-1].append(b-1)
    dp_arr = [[-1, -1] for _ in range(len(sales))]

    def dp(now, check):
        if len(arr[now]) == 0:
            return 0
        if dp_arr[now][check] != -1:
            return dp_arr[now][check]
        res = 0
        if check:
            for nx in arr[now]:
                res += min(dp(nx, False), dp(nx, True) + sales[nx])
        else:
            flag = False
            temp = sales[now]
            for nx in arr[now]:
                m1 = dp(nx, False)
                m2 = dp(nx, True) + sales[nx]
                if m2 <= m1:
                    flag = True
                    res += m2
                else:
                    if m2 - m1 < temp:
                        temp = m2 - m1
                    res += m1
            if not flag:
                res += temp
        dp_arr[now][check] = res
        return res
    answer = dp(0, False)
    return answer
