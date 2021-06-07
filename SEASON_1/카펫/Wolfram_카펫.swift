// 21/03/25 Solved By Wolfram Hwang
// 먼저, 문제 정황 상 브라운은 전체 테두리에 다 걸려있습니다.
// 그렇다면 사각형의 형태 (AxB)에서 A, B만 정해주고
// 값을 비교하면 됩니다.
// 사각형의 형태를 정해주는 것은 완전탐색을 해도 되긴 하겠으나
// 굳이 다 할 필욘 없고, 사각형 전체 넓이의 루트 값까지만 Col 값을 올려보면서
// 탐색해 나가면 됩니다.
// 해당 문제의 시간 복잡도는 O(25000^(1/2)) 입니다. ^^
import Foundation

func solution(_ brown:Int, _ yellow:Int) -> [Int] {
    let Total : Int = brown + yellow
    var ans: [Int] = [Int]()
    var row: Int = 0
    var col: Int = 2

    while((col * col) <= Total){
        if Total % col == 0 {
            row = Total / col
            let dummyBrown: Int = (row * 2) + ((col - 2) * 2)
            if dummyBrown == brown{
                ans.append(row)
                ans.append(col)
                break
            }
        }

        col += 1
    }

    return ans
}
