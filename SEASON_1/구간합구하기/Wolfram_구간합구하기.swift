//
//  main.swift
//  algoswift
//
//  Created by 황지웅 on 2021/05/15.
//

import Foundation


let NMK = readLine()!.split(separator: " ").map{Int(String($0))!}
let N = NMK[0]
let M = NMK[1]
let K = NMK[2]
var arr : [Int] = [0]
for _ in 0..<N{
    arr.append(Int(readLine()!)!)
}
var tree : [Int] = [Int](repeating: 0, count: N << 2)

func Init (_ left: Int, _ right: Int, _ node: Int)->Int{
    if left == right {
        tree[node] = arr[left]
        return tree[node]
    }
    let mid = (left + right) / 2
    tree[node] += Init(left, mid, node * 2)
    tree[node] += Init(mid + 1, right, node * 2 + 1)
    return tree[node]
}

func update(_ left: Int, _ right: Int, _ node :Int, _ diffNode: Int, _ diff : Int )  {
    if !(left <= diffNode && diffNode <= right) {
        return
    }
    tree[node] += diff
    if left != right {
        let mid = (left + right) / 2
        update(left, mid, node * 2, diffNode, diff)
        update(mid + 1, right, node * 2 + 1, diffNode, diff)
    }
}

func sum(_ node: Int, _ left: Int, _ right: Int, _ start: Int, _ end: Int) -> Int {
    if right < start || end < left {
        return 0
    }
    if start <= left && right <= end{
        return tree[node]
    }
    let mid = (left + right) / 2
    let val = sum(node * 2, left, mid, start, end) + sum(node * 2 + 1, mid + 1, right, start, end)
    return val
}

Init(1, N, 1)
for _ in 0..<(M + K) {
    let abc = readLine()!.split(separator: " ").map{Int(String($0))!}
    if abc[0] == 1{
        let diff = abc[2] - arr[abc[1]]
        arr[abc[1]] = abc[2]
        update(1,N,1,abc[1],diff)
    }else{
        let val = sum(1,1,N,abc[1],abc[2])
        print(val)
    }
}
