class Solution {
    fun myAtoi(s: String): Int {
        var sb = StringBuilder()
        var cnt = 0
        var negative = false
        var res = 0
        var i = 0
        while(i < s.length && s[i] == ' ')++i
        negative = i < s.length && s[i] == '-' 
        i += if(i < s.length && (s[i] == '-' || s[i] == '+')) 1 else 0
        while(i < s.length) {
            var c = s[i]
            when (cnt){
                0->{
                    if(c in '0' .. '9') {if(sb.length != 0 || c != '0')sb.append(c)} 
                    else cnt++
                }
                else->{
                    
                }
            }
            ++i
        }
        var intMax = if(negative) "2147483648" else "2147483647"
        if(sb.length > 10 || (sb.length == 10 && intMax <= sb.toString())){
            return if(negative) -2147483648 else 2147483647
        }
        if(sb.length == 0) sb.append('0')
        return (if(negative) -1 else 1) * sb.toString().toInt()
    }
}
