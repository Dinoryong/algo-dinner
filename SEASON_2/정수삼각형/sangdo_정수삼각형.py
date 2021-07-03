def solution(triangle):
    answer = 0
    for i in range(1, len(triangle)):
        for j in range(i+1):
            triangle[i][j] = triangle[i][j] + max([0 if j == 0 else triangle[i-1][j-1], 0 if j == i else triangle[i-1][j]])
    return max(triangle[len(triangle)-1])
