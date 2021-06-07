"""
Greedy

set 으로 : 객체끼리 집합 연산 지원 (list는 차집합 연산 지원 X -> 중복이 있는 list끼리 차집합
연산을 수행하기 위해서는 Counter 객체를 사용)
(https://wikidocs.net/1015)

[IDEA]
reserve 의 i-1값, i+1값이 lost에 포함되어있다면 제거
(왼쪽부터 제거) -> 이건 당연하게 ? 느껴짐
n - lost '=' 체육 수업 들을 수 있는 학생 수


"""
def solution(n, lost, reserve):

    set_lost = set(lost) - set(reserve)
    set_reserve = set(reserve) - set(lost)

    answer = 0    
    for i in set_reserve:
        if (i-1) in set_lost:
            set_lost.remove(i-1)
        elif (i+1) in set_lost:
            set_lost.remove(i+1)
    answer = n - len(set_lost)

    return answer