"""

"""
def solution(s):
    length = []
    result = ""

    # s 의 총길이가 1이라면 비교대상 없이, 바로 1을 리턴한다.
    if len(s) == 1:
        return 1

    # 어디까지 잘라서 볼지는 cut 를 옮겨가며 결정한다.
    # 
    for cut in range(1, len(s) // 2 + 1):
        count = 1
        tempStr = s[:cut]
        for i in range(cut, len(s), cut):
            if s[i:i + cut] == tempStr:
                count += 1
            else:
                if count == 1:
                    count = ""
                result += str(count) + tempStr
                tempStr = s[i:i + cut]
                count = 1

        if count == 1:
            count = ""
        result += str(count) + tempStr
        length.append(len(result))
        result = ""

    return min(length)
