"""

"""
def checktr(t,lst):
    c = 0
    start = t
    end = t+1000
    for i in lst:
        if i[1] >= start and i[0] < end:
            c += 1
    return c

def solution(lines):
    lst = []
    r = 1
    for line in lines:
        y, a, b = line.split()
        a = a.split(':')
        b = float(b.replace('s', '')) * 1000
        end = (int(a[0])*3600 + int(a[1])*60 + float(a[2]))*1000
        start = end-b+1
        lst.append([start,end])
    for i in lst:
        r = max(r, checktr(i[0], lst), checktr(i[1], lst))
    return r
