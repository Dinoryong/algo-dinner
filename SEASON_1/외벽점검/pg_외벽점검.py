"""
2020 블채


python :

"""
#
from itertools import permutations
def solution(n, weak, dist):
    L = len(weak)
    cand = []
    weak_point = weak + [w+n for w in weak]

    for i, start in enumerate(weak):
        for friends in permutations(dist):
            count = 1
            position = start
            # 친구 조합 배치
            for friend in friends:
                position += friend
                if position < weak_point[i+L-1]:
                    count += 1
                    position = [w for w in weak_point[i+1:i+L]
                                if w > position][0]
                else:
                    cand.append(count)
                    break

    return min(cand) if cand else -1