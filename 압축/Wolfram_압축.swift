// Solved by Wolfram Hwang
// 압축 문제입니다.
// 이전 것을 순차적으로 탐색하면서, 만약 없던것이라면 그 전의 것을 넣음
// 있다면 계속 합치기
    }

    for c in msg {
        starr.append(String(c))
    }
    var str = starr[0]
    for i in 1..<starr.count {
        let next = str + starr[i]
        if let v = dict[next] {
            str = next
        }else{
            if let v = dict[str] {
                ans.append(v)
            }
            dict[next] = idx
            idx += 1
            str = starr[i]
        }
    }
    if let v = dict[str] {
        ans.append(v)
    }
    return ans
}
