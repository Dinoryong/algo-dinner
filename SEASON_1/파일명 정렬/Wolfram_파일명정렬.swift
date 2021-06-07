// solved by Wolfram Hwang
// 문제 조건에 맞게
// 정렬을 해주면 됩니다.
// 공부 할겸 Merge Sort를 사용했어요

struct str{
    var HEAD: String
    var nn: String
    var number: Int
    var tail: String
    var index : Int
    init(_ head: String, _ nn: String, _ nb: Int, _ tail: String, _ idx: Int){
        self.HEAD = head
        self.nn = nn
        self.number = nb
        self.tail = tail
        self.index = idx
    }
}

func merge(_ left: [str], _ right: [str]) -> [str] {
    var merged: [str] = []	
    var leftPoint = 0		
    var rightPoint = 0
    
    while left.count > leftPoint, right.count > rightPoint {
        if left[leftPoint].HEAD.uppercased() > right[rightPoint].HEAD.uppercased() {
            merged.append(right[rightPoint])
            rightPoint += 1
        }else if left[leftPoint].HEAD.uppercased() == right[rightPoint].HEAD.uppercased() {
            if left[leftPoint].number > right[rightPoint].number {
                merged.append(right[rightPoint])
                rightPoint += 1
            }
            else if left[leftPoint].number == right[rightPoint].number {
                if left[leftPoint].index > right[rightPoint].index {
                    merged.append(right[rightPoint])
                    rightPoint += 1
                }else{
                    merged.append(left[leftPoint])
                    leftPoint += 1        
                }
            }
            else{
                merged.append(left[leftPoint])
                leftPoint += 1    
            }
        }else{
            merged.append(left[leftPoint])
            leftPoint += 1
        }
    }
    
    while left.count > leftPoint {
        merged.append(left[leftPoint])
        leftPoint += 1
    }
    
    while right.count > rightPoint {
        merged.append(right[rightPoint])
        rightPoint += 1
    }
    
    return merged
}

func split(data: [str]) -> [str] {
    if data.count <= 1 { return data }
    let medium = Int(data.count / 2)    
    let left = split(data: Array(data[0..<medium]))
    let right = split(data: Array(data[medium...]))    
    return merge(left, right)
}

func solution(_ files:[String]) -> [String] {
    var originString: [str] = []
    var number : [String: Bool] = [String: Bool]()
    for i in 0...9{
        number[String(i)] = true
    }
    var idx = 0
    for string in files {
        var HEAD = ""
        var nb = ""
        var tail = ""
        for c in string {
            if let v = number[String(c)]{
                if tail == "" {
                    nb += String(c)
                }else{
                    tail += String(c)
                }
            }else{
                if nb == "" {
                    HEAD += String(c)
                }else{
                    tail += String(c)
                }
            }
        }
        let x = str(HEAD, nb, Int(nb)!, tail, idx)
        originString.append(x)
        idx += 1
    }
    originString = split(data: originString)
    var ans: [String] = []
    for x in originString {
        let strr = x.HEAD + x.nn + x.tail
        ans.append(strr)
    }
    return ans
}
