import Foundation
var ox : [Int] = [Int](repeating: 0, count: 21)
var st: Set<String> = Set<String>()
func go(_ str: [String], _ idx : Int, _ val : String) {
    if idx >= str.count {
        if val.count >= 2, ox[val.count] == 1 {
            st.insert(val)
        }
        return
    }
    go(str, idx + 1, val + str[idx])
    go(str, idx + 1, val)
}
func solution(_ orders:[String], _ course:[Int]) -> [String] {
    for i in course {
        ox[i] = 1
    }
    var map : [String: Int] = [String: Int]()
    var ref : [Int] = [Int](repeating: 0, count: 21)
    for i in 0..<(orders.count - 1) {        
        for j in (i + 1)..<(orders.count) {
            var inp: [String] = []
            for c1 in orders[i] {
                for c2 in orders[j] {
                    if c1 == c2 {
                        inp.append(String(c1))                        
                    }
                }
            }
            if inp.count >= 2 {
                inp = inp.sorted()
                go(inp, 0, "")    
            }
            
        }       
    }


    for val in st{
        for str in orders {
            var ok = true
            for c1 in val {
                if str.contains(c1) == false {
                    ok = false
                }
            }
            if ok == true {
                if let v = map[val] {
                    map[val]? += 1
                }else{
                    map[val] = 1
                }
                if ref[val.count] < map[val]! {
                    ref[val.count] = map[val]!
                }
            }
        }
    }
    print(map)
    var ans : [String] = []
    for (key, value) in map {
        if ref[key.count] == value, ox[key.count] == 1 {
            ans.append(key)
        }
    }
    ans = ans.sorted()
    return ans
}
