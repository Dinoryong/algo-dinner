"""

"""
def solution(s):
    length = []
    result = ""

    # s 의 총길이가 1이라면 비교대상 없이, 바로 1을 리턴한다.
    if len(s) == 1:
        return 1

    # 문자열을 자르는 단위는 cut
    # cut 의 범위는 총 문자열 s 길이의 절반을 넘어갈 필요가 없다.
    for cut in range(1, len(s) // 2 + 1):
        # count 는 문자열 반복 단위 횟수로, 처음에는 1로 초기화한다.
        # tempStr 은 문자열에서 처음부터 문자열 반복 단위 까지 자른 문자열이다.
        count = 1
        tempStr = s[:cut]
        # cut (문자열 단위)만큼, 건너뛰면서 반복한다.
        for i in range(cut, len(s), cut):
            # 이전 문자열과 그 다음 건너뛴 문자열이 같다면, count 값을 1 올려준다.
            if s[i:i + cut] == tempStr:
                count += 1
            # 다르다면
            # count 값이 1일 경우에는 생략하기 위해 string 빈 값으로 주고
            # 최종 결과에는 문자열반복단위를 문자열로 바꾼 후에 tempStr과 합쳐준다.
            else:
                if count == 1:
                    count = ""
                result += str(count) + tempStr
                # tempStr 은 그 다음 반복문자열을 찾기 위해 갱신해준다
                # count 도 마찬가지로 갱신해준다.
                tempStr = s[i:i + cut]
                count = 1

        if count == 1:
            count = ""
        result += str(count) + tempStr
        length.append(len(result))
        result = ""

    return min(length)
