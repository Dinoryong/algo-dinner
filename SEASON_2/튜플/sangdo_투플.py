class MYCLASS:
    def __init__(self, li):
        self.li = li
        
    def __lt__(self, other):
        return len(self.li) < len(other.li)
    
def solution(s):
    li = [MYCLASS(list(map(int, sss[0].split(",")))) for sss in [ss.split("}") for ss in s[1:-1].split("{")][1:]]
    li.sort()
    chk = set()
    answer = [0]*len(li)
    for i in range(len(li)):
        for v in li[i].li:
            if v not in chk:
                answer[i] = v
                chk.add(v)
    return answer
