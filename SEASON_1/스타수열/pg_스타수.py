"""
부분수열, dp?
python
Counter()


스타수열 -> 가장 길이가 긴 것 return
하나의 부분 수열 안에서 겹치는 원소 없고 (다 2개 원소 지님)
a 원소의 순서는 상관 없음
x 의 길이 : 2n

1 2 , 1 3 , 4 1 , 1 3

5 2 , 3 3 ,  5 3
[5 2 5 3] [5 3 3 5] 4

0 3, 3 0, 7 3, 0 2, 2 0 => 0 4개 2 2개 3 3개 7 1개
[0 3 3 0 7 0 2 0] 8

# 스케치 : 공통 원소 몇 번 등장하는지가 스타 수열 최대 길이 결정
once ...
1) 원소 등장 횟수 카운팅

2) 조건
o : 2)
x ; return 0
"""
from collections import Counter

def solution(a):
    # 각 원소 등장 횟수 카운팅
    elements = Counter(a)
    answer = -1

    # a 배열 원소 i 기준
    for i in elements.keys():
        if elements[i] <= answer:
            continue
        cnt, idx = 0, 0

        # 계속 가
        while idx < len(a) - 1:
            # 조건 확인
            if (a[idx] != i and a[idx + 1] != i) or (a[idx] == a[idx + 1]):
                idx += 1
                continue

            # 스타수열 원소 편입 가능 시, i 원소 사용 횟수 1 증가
            cnt += 1
            # 다음 탐색으로 넘어감
            idx += 2

    # 공통원소 i가 사용된 횟수의 최댓값
    answer = max(cnt, answer)

# 배열이 2가지 원소로 이루어지는 배열의 배열임에 주의
    if answer == -1:
        return 0
    else:
        # 스타수열의 길이는 공통원소 i가 사용된 횟수 * 2
        return (answer * 2)