class Solution {
    fun solution(name: String): Int {
        var answer = 0
        var sb = StringBuilder()
        for(i in 1 .. name.length){
            sb.append("A")
        }
        
        var command = IntArray(26)
        
        for(i in 'A'.toInt() .. 'Z'.toInt()){
            command[i-'A'.toInt()] = Math.min(i.toInt() - 'A'.toInt(), (26 + 'A'.toInt()-i.toInt()))
        }
        var now = 0
        while(name != sb.toString()) {
            var left = 0
            var right = 0
            while(sb[(name.length + now -left) % name.length] == name[(name.length + now - left)%name.length]) left++
            while(sb[(now+right) % name.length] == name[(now + right) % name.length]) right++
            if(left < right){
                now = (name.length + now - left) % name.length
                answer += left
            }
            else{
                now = (now + right)%name.length
                answer += right
            }
            answer += command[name[now].toInt()- 'A'.toInt()]
            sb[now] = name[now]
        }
        
        return answer
    }
}