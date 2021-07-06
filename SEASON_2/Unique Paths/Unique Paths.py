"""
math
dp
recursive
dfs

res = right + down
base case 설정을 위해 , finish point 1로 설정하고 거꾸로 가보기
"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # 맨 마지막 행
        row = [1] * n

        # 맨 마지막 행 제외한 모든 행
        for i in range(m - 1):
            newRow = [1] * n
            # 거꾸로 간다, 가장 오른쪽 열 제외, 오른쪽에서 왼쪽으로
            for j in range(n - 2, -1, -1):
                # 가짓수 더해서 적어주기
                newRow[j] = newRow[j + 1] + row[j]
            row = newRow
        return row[0]

    # time complexity: O(n * m) , memory complexity: O(n)
