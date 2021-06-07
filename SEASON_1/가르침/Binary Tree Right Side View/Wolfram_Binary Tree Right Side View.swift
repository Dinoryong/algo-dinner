// Solved by Wolfram Hwang
// IDE없이 풀려니까 계속 옵셔널문법에서 에러가났네요..
// 일단 아이디어는 간단하다고 생각해요.
// 동일한 sibling 레벨 레이어에서 가장 오른쪽에 있는 친구들을 모아서 리턴 하면 됩니다.
// 노드 개수도 많지않아서 완전탐색으로 충분히 가능하구요.. 그런 문제가 되겠네요!
class Solution {
    var arr : [[Int]] = []
    var mx : Int = 0
    func go(_ node: TreeNode?, _ cnt : Int){
        if node == nil {
            return
        }
        if let v = node?.val {
            if arr.count <= cnt {
                let layer : [Int] = [v]
                arr.append(layer)
            }else{
                arr[cnt].append(v)   
            }
            if mx < cnt {
                mx = cnt
            }
        }
        go(node?.left, cnt + 1)
        go(node?.right, cnt + 1)
    }
    func rightSideView(_ root: TreeNode?) -> [Int] {
        if root == nil {
            return []
        }
        var ans : [Int] = []        
        let layer: [Int] = []
        arr = [[Int]](repeating: layer, count : 2)
        go(root, 1)
        for i in 1...mx {
            if arr[i].count > 0 {
                ans.append(arr[i][arr[i].count - 1])
            }
        }
        return ans
    }
}
