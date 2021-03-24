```
종이로 만들 수 있는 숫자들의 조합 케이스를 모두 살펴봐야 한다.
```
# 입력 값 받기
from itertools import permutations

def solution(numbers):
    set_num = set()
    for i in range(len(numbers)):
        set_num |= set(map(int,map(''.join, permutations(list(numbers), i+1))))
    set_num -= set(range(2))
    for i in range(2, int(max(set_num)**0.5)+1):
        set_num -= set(range(i*2, max(set_num)+1, i))
    return len(set_num)


```
set의 차집합 기능과 range 함수의 interval 기능으로
에르토스테네스의 체를 구현할 수 있다!
```
