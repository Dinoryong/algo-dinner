import java.util.*

class Solution {
    fun solution(number: String, k: Int): String {
        var st = Stack<Char>()
        var k = k
        for(i in 0 until number.length){
            while(st.isNotEmpty() && st.peek() < number[i] && k > 0){
                k--
                st.pop()
            }
            st.push(number[i])
        }
        var sb = StringBuilder()
        while(st.isNotEmpty()){
            sb.append(st.pop())
        }
        
        return sb.reverse().toString().substring(0, sb.length - k)
    }
}