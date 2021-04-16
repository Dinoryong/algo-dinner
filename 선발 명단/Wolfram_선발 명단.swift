// Solved by Wolfram Hwang
// 단순한 재귀 함수 문제네요.
// 딱히 백트래킹이라 할만한 요소는 없는 것 같습니다.

import Foundation

let n = Int(readLine()!)!
for _ in 0..<n{
    var player = [[Int]]()
    for _ in 0..<11 {
        player.append(readLine()!.split(separator: " ").map{Int(String($0))!})
    }
    var max = 0
    let len = player.count
    var position: [Int] = [Int](repeating: 0, count: len)
    func go(_ playerNumber: Int, _ point: Int){
        if len == playerNumber {
            if max < point {
                max = point
            }
            return
        }
        for i in 0..<len {
            if player[playerNumber][i] == 0 {
                continue
            }
            if position[i] == 1{
                continue
            }
            position[i] = 1
            go(playerNumber + 1, point + player[playerNumber][i] )
            position[i] = 0
        }
    }
    
    go(0,0)
    print(max)
    
}

