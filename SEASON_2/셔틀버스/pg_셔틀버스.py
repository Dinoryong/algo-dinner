def solution(n, t, m, timetable):
    answer = ''
    timetable = [int(time[:2]) * 60 + int(time[3:5]) for time in timetable]
    timetable.sort()
    last_time = (60 * 9) + (n - 1) * t

    for i in range(n):
        if len(timetable) < m: return '%02d:%02d' % (last_time // 60, last_time % 60)
        if i == n - 1:
            if timetable[0] <= last_time: last_time = timetable[m - 1] - 1
            return '%02d:%02d' % (last_time // 60, last_time % 60)
        for j in range(m - 1, -1, -1):
            bus_arrive = (60 * 9) + i * t
            if timetable[j] <= bus_arrive:
                del timetable[j]

