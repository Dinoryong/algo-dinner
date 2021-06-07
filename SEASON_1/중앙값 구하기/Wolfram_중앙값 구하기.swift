// Solved by Wolfram Hwang
// HEAP 두 개를 유연하게 잘 사용하면 되는 문제입니다.

import Foundation
struct heap {
    var lastn = 0
    var heap : [Int] = []
    init(_ size: Int) {
        lastn = 0
        heap = [Int](repeating: 0, count: size)
    }
    
    mutating func push(_ input: Int, comp: (_ s1: Int,_ s2: Int) -> Bool) {
        self.lastn += 1
        heap[self.lastn] = input
        var C = lastn
        var P = C / 2
        while P > 0 && !comp(heap[P], heap[C]) {
            let temp = heap[P]
            heap[P] = heap[C]
            heap[C] = temp
            C = P
            P = C / 2
        }
    }
    
    mutating func pop(comp: (_ s1: Int,_ s2: Int) -> Bool) {
        heap[1] = heap[self.lastn]
        self.lastn -= 1
        var P = 1
        var L = 2
        var R = 3
        var C = 0
        while L <= self.lastn {
            if R > lastn {
                C = L
            }else {
                C = comp(heap[L], heap[R]) ? L: R
            }
            if comp(heap[P], heap[C]){
                break
            }
            let temp = heap[P]
            heap[P] = heap[C]
            heap[C] = temp
            P = C; L = P * 2; R = L + 1
        }
    }
}
let T = Int(readLine()!)!
for _ in 0..<T {
    var arr: [Int] = []
    var ans : [Int] = []
    let M = Int(readLine()!)!
    var div = M / 10
    let res = M % 10
    if res != 0 {
        div += 1
    }
    for _ in 0..<div {
        let dummyArr = readLine()!.split(separator: " ").map{Int(String($0))!}
        arr += dummyArr
    }
    var minheap : heap = heap(M + 1)
    var maxheap : heap = heap(M + 1)
    let compmax = { (_ s1: Int, _ s2: Int) -> Bool in
        return s1 >= s2
    }

    let compmin = {(_ s1: Int, _ s2: Int)->Bool in
        return s1 <= s2
    }
    
    let v = { (_ d : Int) in
        if maxheap.heap[1] < d {
            minheap.push(d, comp: compmin)
            if maxheap.lastn < minheap.lastn {
                maxheap.push(minheap.heap[1], comp: compmax)
                minheap.pop(comp: compmin)
            }
        }
        else {
            maxheap.push(d, comp: compmax)
            if maxheap.lastn > minheap.lastn + 1 {
                minheap.push(maxheap.heap[1], comp: compmin)
                maxheap.pop(comp: compmax)
            }
        }
    }
    var idx = 1
    ans.append(arr[0])
    maxheap.push(ans[0], comp: compmax)
    while idx < arr.count {
        let a = arr[idx]
        let b = arr[idx + 1]
        idx += 2
        v(a); v(b)
        ans.append(maxheap.heap[1])
    }
    print("\((idx / 2) + 1)")
    var ansStr = ""
    for i in 0..<ans.count {
        if i != 0 && i % 10 == 0 {
            ansStr += "\n"
        }
        ansStr += String(ans[i]) + " "
    }
    print(ansStr)
}




