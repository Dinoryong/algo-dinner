"""
***CHECK***

Array 정렬

BruteForce 완전탐색 -> 시간 초과

[IDEA 가져옴]
숫자를 문자열로 바꾼 후에,
3을 곱하면 각 숫자가 3번 반복된 3자리수가 된다. (수능 때 많이 썼던 기억)
정렬을 하면 오름차순으로 정렬이 된다.
reverse 해서 내림차순으로 정렬.

join 함수는 배열을 특정 문자로 구분하여
문자열로 변환해주는 함수이다.

근데 왜 string 을 int 로 변환하고,
다시 string 으로 변환해서 리턴하는지,
이해가 안됐는데

그렇게 join 만 사용하면 0일 때가 문제다.

[0, 0, 0, 0] 을 input 으로 넣는다면 '0000'이 리턴되므로,
int 로 변환해서 '0' 으로 바꿔야 한다.

그리고 오버플로우 방지를 위해
다시 str 으로 변환해야 하는 것!!!!
"""
# Time Complexity
# Space Complexity
def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key = lambda x: x*3, reverse=True)
    return str(int(''.join(numbers)))