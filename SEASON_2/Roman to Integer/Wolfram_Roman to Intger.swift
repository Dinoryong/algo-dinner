class Solution {
    func romanToInt(_ s: String) -> Int {
        var map : [String : Int] = [String: Int]()
        map["I"] = 1
        map["V"] = 5
        map["X"] = 10
        map["L"] = 50
        map["C"] = 100
        map["D"] = 500
        map["M"] = 1000
        map["IV"] = 4; map["IX"] = 9
        map["XL"] = 40; map["XC"] = 90
        map["CD"] = 400; map["CM"] = 900
        var ans = 0
        var before : String = ""
        for c in s {
            if let v = map[before + String(c)] {
                ans -= map[before] ?? 0
                ans += v
                before = String(c)
            }else{
                ans += map[String(c)] ?? 0
                before = String(c)
            }
        }
        return ans
    }
}
