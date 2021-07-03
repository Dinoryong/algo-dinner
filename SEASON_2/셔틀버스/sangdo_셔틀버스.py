def solution(n, t, mm, timetable):
    answer = ''
    table = []
    for tt in timetable:
        table.append(int(tt[0:2])*60 + int(tt[3:]))
    s,e = 0, 24*60
    table.sort()
    table.append(0x3f3f3f3f)
    gone = 0
    while s < e:
        st = 9*60
        m = (s+e)//2
        seat = False
        gone = 0
        for i in range(n) :
            now = 0
            while now < mm  and table[gone] <= st:
                if now < mm and table[gone] > m and not seat:
                    seat = True
                    break
                now+=1; gone+=1
            if now < mm and table[gone] > m and not seat and m <= st:
                seat = True
            st += t
        if seat: s = m+1
        else: e = m
        
    s-=1
    return (str(s//600)+str(s//60%10) + ":" + str(s%60//10) + str(s%60%10))
