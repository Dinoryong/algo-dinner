import Foundation

func solution(_ s:String) -> [Int] {
    let first = 0; let last = s.count - 1
    var idx = 0
    var map : [String: Int ] = [String: Int]()
    var str = ""
    for c in s {        
        if c == "{"{
            continue
        }
        if c == "}" || c == "," {
            if str == "" {
                continue
            }
            if let v = map[str] {
                map[str]? += 1
            }else{
                map[str] = 1
            }
            str = ""
            continue
        }
        str += String(c)
    }
    var arr : [(String, Int)] = []
    for (key, value) in map {
        arr.append((key, value))
    }
    arr = arr.sorted { $0.1 < $1.1}
    var id = arr.count - 1
    var ans : [Int] = []
    while id >= 0 {
        ans.append(Int(arr[id].0)!)
        id -= 1
    }
    return ans
}
