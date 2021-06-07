"""
python : heapq, collections -> defaultdict, product(이건 메모리 비효율적)

21 공채 문제

그래프 최단 거리
다익스트라
or 플로이드 와샬?

출발 지점에 대해서 모든 경로에 대한 최단 거리 구하기
출발 지점 ~ 환승 지점, 환승지점 ~ a, 환승지점 ~ b 거리
=> 요금 더한 후, 최소값 구하기
"""
# 다익스트라
import heapq

INF = int(1e9)
# 함수 정의하기 전에는 원래 2줄을 비워야하나? 이제 알았다.


def dijkstra(distance, start, graph):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, curr = heapq.heappop(q)
        if distance[curr] < dist:
            continue
        for i in graph[curr]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


def solution(n, s, a, b, fares):
    graph = [[] for _ in range(n + 1)]
    for fare in fares:
        x, y, z = fare
        graph[x].append((y, z))
        graph[y].append((x, z))

    distance = [INF] * (n + 1)
    dijkstra(distance, s, graph)
    ans = INF
    for i in range(1, n + 1):
        result = 0
        distance_tmp = [INF] * (n + 1)
        dijkstra(distance_tmp, i, graph)
        result = distance[i] + distance_tmp[a] + distance_tmp[b]
        ans = min(ans, result)
    return ans


# 플루이드 와샬 이구나
def solution(n, s, a, b, fares):
    INF = 1e9
    adj = [[INF for _ in range(n + 1)] for _ in range(n + 1)]

    for v1, v2, cost in fares:
        adj[v1][v2] = cost
        adj[v2][v1] = cost

    for k in range(1, n + 1):
        for v1 in range(1, n + 1):
            for v2 in range(1, n + 1):
                if v1 == v2:
                    adj[v1][v2] = 0
                    continue

                # 주의
                if adj[v1][v2] > adj[v1][k] + adj[k][v2]:
                    adj[v1][v2] = adj[v1][k] + adj[k][v2]

    answer = adj[s][a] + adj[s][b]
    for i in range(1, n + 1):
        answer = min(answer, adj[s][i] + adj[i][a] + adj[i][b])

    return answe
