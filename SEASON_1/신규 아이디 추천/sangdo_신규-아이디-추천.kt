class Solution {
    fun solution(new_id: String): String {
        var answer: String = ""
        var sb = StringBuilder(new_id)
        var next_sb = StringBuilder()
        for(c in new_id){
            next_sb.append(
            when {
                c in 'A' .. 'Z' -> (c.toInt()-'A'.toInt()+'a'.toInt()).toChar()
                else-> c
            })
        }
        sb = next_sb
        next_sb = StringBuilder()
        
        for(c in sb){
            when(c) {
                in 'a'.. 'z'-> next_sb.append(c)
                '-' ->next_sb.append(c)
                '_' ->next_sb.append(c)
                '.'->next_sb.append(c)
                in '0'..'9' ->next_sb.append(c)
            }
        }
        sb = next_sb
        next_sb = StringBuilder()
        for(c in sb){
            if(c == '.' && next_sb.length > 0 && next_sb.last() == '.'){
                continue
            }
            next_sb.append(c)
        }
        var first = if(next_sb.length > 0 && next_sb[0] == '.') 1 else 0
        var last = if(next_sb.length > 0 && next_sb.last() == '.') next_sb.length-1 else next_sb.length
        last = Math.max(first,last)
        sb = StringBuilder(next_sb.substring(first, last))
        if(sb.length== 0) sb.append('a')
        if(sb.length > 15) sb = StringBuilder(sb.substring(0,15))
        if(sb.length > 0 && sb.last() == '.') sb = StringBuilder(sb.substring(0,sb.length-1))
        if(sb.length <= 2) while(sb.length < 3) sb.append(sb.last())
        
        return sb.toString()
    }
}
