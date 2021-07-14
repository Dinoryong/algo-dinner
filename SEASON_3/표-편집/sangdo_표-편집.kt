import java.util.*

class MyList(var idx:Int = -1,var prev: MyList? = null, var next: MyList? = null)
class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        var head = MyList()
        head.prev = head!!
        head.next = head!!
        var cur:MyList = head
        
        for(i in 0 until n) {
            var nn = MyList(idx=i, prev= head.prev, next = head)
            nn.prev!!.next = nn
            nn.next!!.prev = nn
            
            if (k == i) cur = nn
        }
        var stack = Stack<MyList>()
        for(s in cmd){
            var sp = s.split(" ")
            if(sp[0] == "D") {
                var move = sp[1].toInt()
                while(cur.next!! != head && move != 0) {
                    cur = cur.next!!
                    move--
                }
            }
            else if(sp[0] == "C") {
                cur.prev!!.next = cur.next
                cur.next!!.prev = cur.prev
                
                stack.add(cur)
                cur = cur.next!!
                if(cur == head) cur = cur.prev!!
            }
            else if(sp[0] == "U"){
                var move = sp[1].toInt()
                while(cur.prev!! != head && move != 0) {
                    cur = cur.prev!!
                    move--
                }
                
            }
            else if(sp[0] == "Z") {
               	if(stack.isNotEmpty()) {
                    var d = stack.pop()
                    d.next!!.prev = d
                    d.prev!!.next = d
                }
            }
            
        }
        
        var answer = StringBuilder()
        for(i in 1 .. n){
            answer.append("X")
        }
        
        var cur2 = head.next!!
        while(cur2 != head){
            answer[cur2.idx] = 'O'
            cur2 = cur2.next!!
        }
        
        return answer.toString()
    }
}
