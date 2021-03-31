"""
비슷한 문제를 봤는데,,,

문제 이해를 잘 해야 한다.

"""
# 처음 sketch
def solution(citations):
    citations.sort()
    list = []
    for i in range(len(citations)):
        if citations[i] <= len(citations) - i - 1 :
            list.append(citations[i])

    answer = max(list)
    return answer

# sol
def solution(citations):
    for i in range(max(citations), -1, -1):
        if sum(1 for j in citations if j >= i) >= i: break
    return i