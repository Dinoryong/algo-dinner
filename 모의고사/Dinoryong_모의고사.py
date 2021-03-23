# 완전탐색을 해야 한다. 다른 더 효율적인 방법이 있을 수 있나?
# 시간복잡도

def solution(answers):
    # 학생들의 찍기 패턴 입력값 받아옴
    pattern_1 = [1, 2, 3, 4, 5]
    pattern_2 = [2, 1, 2, 3, 2, 4, 2, 5]
    pattern_3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    # 학생1, 학생2, 학생3의 점수를 초기화
    score_1 = score_2 = score_3 = 0

    # 정답지(answers)와 학생들의 찍기 패턴을 완전탐색으로 비교하며
    # 정답을 맞췄을 경우, 각 학생의 점수를 올려준다.
     for i in range(len(answers)):
        if answers[i] == pattern_1[i%(len(pattern_1))]:
            score_1 +=  1
        if answers[i] == pattern_2[i%(len(pattern_2))]:
            score_2 += 1
        if answers[i] == pattern_3[i%(len(pattern_3))]:
            score_3 += 1

    # 정답지와 학생들의 찍기 패턴 대조를 모두 끝낸 후의 각 학생들의 점수 중
    # 가장 높은 점수를(score_top) 먼저 뽑아낸다.
    score_top = max(score_1, score_2, score_3)

    # 가장 높은 점수를 받은 학생 번호를 return 할 answer 배열을 초기화
    answer = []

    # 오름차순 정렬을 위해 학생번호 1->2->3 순서로 차례대로
    # score_top과 각 학생의 점수를 비교하며
    # score_top일 경우에 학생번호를 answer 배열에 오름차순으로 더해준다.
    if score_top == score_1:
        answer.append(1)
    if score_top == score_2:
        answer.append(2)
    if score_top == score_3:
        answer.append(3)

    return answer



