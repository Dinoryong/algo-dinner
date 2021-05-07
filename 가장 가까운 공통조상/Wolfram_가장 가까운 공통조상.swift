import Foundation

let T = Int(readLine()!)!
for _ in 0..<T{
    let M = Int(readLine()!)!
    var parent : [Int] = []
    for i in 0...M {
        parent.append(i)
    }
    for _ in 0..<(M - 1) {
        let node = readLine()!.split(separator: " ").map{Int(String($0))!}
        parent[node[1]] = node[0]
    }
    let node = readLine()!.split(separator: " ").map{Int(String($0))!}

    var find1 = node[0]
    var f : [Int] = [find1]
    while parent[find1] != find1 {
        f.append(parent[find1])
        find1 = parent[find1]
    }
    find1 = node[1]
    var f2 : [Int] = [find1]
    while parent[find1]  != find1{
        f2.append(parent[find1])
        find1 = parent[find1]
    }

    var cnt1 = f.count 
    var cnt2 = f2.count
    for i in 0..<cnt1 {
        var ok = false
        for j in 0..<cnt2 {
            if f[i] == f2[j] {
                print(f[i])
                ok = true
                break
            }
        }
        if ok == true {
            break
        }
    }
}
