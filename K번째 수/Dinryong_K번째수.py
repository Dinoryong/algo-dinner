'''
정렬까지 해야하니까 완전탐색
'''

def solution(array, commands):

    # answer는 (array, commands)가 달라질때마다 초기화
    answer = []

    # 2차원 배열에서 1차원 배열로 순환하면서 1차원배열의 index 뽑아내서,
    # i,j,k 입력값 받아옴
    for command in commands:
        i = command[0]
        j = command[1]
        k = command[2]

        # i,j,k가 index가 아니라 "~번째"임에 주의하며 slicing
        arrays = array[i-1:j]
        arrays.sort()

        # k 번째 있는 수를 answer에 담아낸다.
        answer.append(arrays[k-1])
    return answer