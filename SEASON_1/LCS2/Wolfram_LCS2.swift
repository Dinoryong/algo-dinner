// Solved by Wolfram Hwang
// LCS문제입니다. 딱히 설명할게 없네요

import Foundation
let s1 = readLine()!
let s2 = readLine()!
var str1:[String] = [String]()
var str2:[String] = [String]()

let lay = [Int](repeating: 0, count: 1001)
var dp : [[Int]] = [[Int]](repeating:lay, count: 1001)
for c in s1 {
    str1.append(String(c))
}
for c in s2 {
    str2.append(String(c))
}

for i in 1...str1.count {
    for j in 1...str2.count {
        if str1[i-1] == str2[j-1]{
            dp[i][j] = dp[i-1][j-1] + 1
        }else{
            if dp[i-1][j] < dp[i][j-1] {
                dp[i][j] = dp[i][j-1]
            }else{
                dp[i][j] = dp[i-1][j]
            }
        }
    }
}

print(dp[str1.count][str2.count]);
var i = str1.count
var j = str2.count
var result: [String] = [String]()	
while i >= 1 && j >= 1 {
	if(dp[i][j] == dp[i-1][j]){
		i -= 1
	}else if(dp[i][j] == dp[i][j-1]){
		j -= 1
	}else{
		result.append(String(str1[i-1]));	
		i -= 1
        j -= 1
	}
}
var str = ""
for c in result {
    str += c
}
str = String(str.reversed())
print(str)
