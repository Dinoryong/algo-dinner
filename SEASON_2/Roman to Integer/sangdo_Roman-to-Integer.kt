class Solution {
    fun romanToInt(s: String): Int {
        var hashMap = hashMapOf("M" to 1000, "CM" to 900, "CD" to 400, "D" to 500, "C" to 100, "L" to 50, "X" to 10, "XC" to 90, "XL" to 40, "V" to 5, "I" to 1, "IX" to 9, "IV" to 4)
        var idx = 0
        var res = 0
        while(idx < s.length){
            if(idx + 2 <= s.length && s.substring(idx, idx+2) in hashMap){
                res += hashMap[s.substring(idx, idx+2)]!!
                idx+=2
            }
            else{
                res += hashMap[s[idx].toString()]!!
                idx++
            }
        }
        return res
    }
}
