"""


"""


def calc(stones, k, mid):
    now = 0
    for stone in stones:
        if (stone < mid):
            now += 1

        else:
            now = 0
        if (now >= k):  
            return False
    return True


def solution(stones, k):
    left = 1
    right = max(stones) + 1
    while (left < right - 1):
        mid = (left + right) // 2
        if (calc(stones, k, mid)):
            left = mid
        else:
            right = mid

    return left