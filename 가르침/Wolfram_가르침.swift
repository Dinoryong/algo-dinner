//
//  main.swift
//  AlgoSwift
//
//  Created by 황지웅 on 2021/05/20.
//

import Foundation

let NK = readLine()!.split(separator: " ").map{Int(String($0))!}
let alphabet = "abcdefghijklmnopqrstuvwxyz"
var dic : [Character : Int] = [Character: Int]()
var cnt = 1
for c in alphabet {
    dic[c] = cnt
    cnt += 1
}
var word: [Int] = []
for _ in 0..<NK[0] {
    let str = readLine()!
    word.append(strToBit(str))
}

//a n t i c
let dummy = "bdefghjklmopqrsuvwxyz"
var strArr : [String] = []
for dm in dummy {
    strArr.append(String(dm))
}

func strToBit(_ str :String) -> Int {
    var ret = 0
    for c in str {
        guard let v = dic[c] else {
            return 0
        }
        ret |= (1 << v)
    }
    return ret
}
var ans = 0
func makeComb(_ idx : Int, _ cnt: Int, _ str: String) {
    if cnt == 0 {
        let val = strToBit(str)
        var ret = 0
        for x in word {
            if (x & val) == x{
                ret += 1
            }
        }
        if ret > ans {
            ans = ret
        }
        return
    }
    if idx >= strArr.count {
        return
    }
    makeComb(idx + 1, cnt - 1, str + strArr[idx])
    makeComb(idx + 1, cnt, str)
}

if NK[1] - 5 >= 0 {
    makeComb(0, NK[1] - 5, "antic")
    print(ans)
}else{
    print(ans)
}

