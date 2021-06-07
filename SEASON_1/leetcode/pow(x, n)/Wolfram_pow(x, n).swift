// Solved by Wolfram Hwang
// E A S Y

class Solution {
    func myPow(_ x: Double, _ n: Int) -> Double {
        if x == 1 || x == 0 {
            return x
        }
        else if x == -1 {
            if n % 2 == 0{
                return 1
            }
            return -1
        }
        
        var ans: Double = 1
        var inp : Int = n
        var y = x
        if inp < 0 {
            y = 1 / y
            inp = -inp
        }
        
        while inp > 0 {
            if inp % 2 == 0 {
                inp /= 2
                y = y * y
            }else{
                ans *= y
                inp -= 1
            }
        }
        return ans
        
    }
}
