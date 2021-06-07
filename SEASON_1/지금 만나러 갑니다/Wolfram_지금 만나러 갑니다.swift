import Foundation

let NAB = readLine()!.split(separator: " ").map{Int(String($0))!}
let N = NAB[0]
let A = NAB[1]
let B = NAB[2]

var ans = 987654321
var idx = 0
let layer : [Bool] = [Bool](repeating: false, count: 20)
var visit: [[Bool]] = [[Bool]](repeating: layer, count: 500001)


func dfs(_ s: Int, _ cnt: Int) {
    var dist = (1 << cnt)
    if cnt >= idx {
        return
    }
    if s + dist <= N {
        if visit[s + dist][cnt] == false {
            visit[s + dist][cnt] = true
            dfs(s + dist, cnt + 1)
        }
    }
    if s - dist > 0 {
        if visit[s - dist][cnt] == false {
            visit[s - dist][cnt] = true
            dfs(s - dist, cnt + 1)
        }
    }
}

func dfs2(_ s: Int, _ cnt: Int){
    var dist = (1 << cnt)
    if cnt >= idx {
        return
    }
    if s + dist <= N {
        if visit[s + dist][cnt] == true {
            if ans > cnt {
                ans = cnt
            }
        }
        else{
            visit[s + dist][cnt] = true
            dfs2(s + dist, cnt + 1)
        }
    }
    if s - dist > 0 {
        if visit[s - dist][cnt] {
            if ans > cnt {
                ans = cnt
            }
        }else{
            visit[s - dist][cnt] = true
            dfs2(s - dist, cnt + 1)
        }
    }
}

while true {
    if N <= (1 << idx) {
        break
    }
    idx += 1
}
dfs(A, 0)
dfs2(B, 0)
if ans == 987654321 {
    print("-1")
}
else{
    print("\(ans + 1)")
}
