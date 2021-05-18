// Solved by Wolfram Hwang
// 간단한 문제에요
// 구현 문제를 많이 풀다보면 사실 제일간단한게
// 새로운 맵을 선언해서 그 맵안에 newmap[x][y] = oldmap[y][len - x - 1]
// 과 같이 표현을 하면 됩니다.
// 근데, 이 문제는 문제에서 제시되었든 따로 새로운 배열을 만들지 않고 문제를 해결해야 하는만큼
// 간단하게 딱 추가변수 5개만 가지고 문제를 풀었습니다.

class Solution {
    func rotate(_ matrix: inout [[Int]]) {
        let len = matrix.count
        for i in 0..<(len / 2){
            print(i)
            for j in i..<(len - 1 - i) {
                var x = j
                var y = len - 1 - i
                var temp = matrix[j][len - 1 - i]
                matrix[j][len - 1 - i] = matrix[i][j]
                            
                var temp2 = matrix[y][len - 1 - x]
                matrix[y][len - 1 - x] = temp
                
                let tp = x
                x = y
                y = len - 1 - tp
                temp = matrix[y][len - 1 - x]
                matrix[y][len - 1 - x] = temp2
                matrix[i][j] = temp
            }
        }
    }
}
