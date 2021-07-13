class Solution {
     func myAtoi(_ str: String) -> Int {
        var result = 0
        var isPos = true
        var isParsing = false
        
        for ch in str {
            if let i = Int(String(ch)) {
                result = result * 10 + i
                isParsing = true
                guard result <= Int32.max else { return isPos ? Int(Int32.max) : Int(Int32.min) }
                
            } else if !isParsing && (ch == "+" || ch == "-") {
                isPos = ch == "+"
                isParsing = true                
            } else if !isParsing && ch == " " {
                continue                
            } else {
                break
            }
        }
        return isPos ? result : -result
    }
}
