class Solution {
    fun solution(answers: IntArray): IntArray {
        var num1 = intArrayOf(1,2,3,4,5)
        var num2 = intArrayOf(2,1,2,3,2,4,2,5)
        var num3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)
        var ok1 = 0
        var ok2 = 0
        var ok3 = 0
        for(i in answers.indices) {
            ok1 += if(num1[(i%num1.size)] == answers[i]) 1 else 0
            ok2 += if(num2[i%num2.size] == answers[i]) 1 else 0
            ok3 += if(num3[i%num3.size] == answers[i]) 1 else 0
        }
        var max = Math.max(ok1,ok2)
        max = Math.max(max, ok3)
        var num = 0
        num += if(ok1 == max) 1 else 0
        num += if(ok2 == max) 1 else 0
        num += if(ok3 == max) 1 else 0
<<<<<<< HEAD

=======
        
>>>>>>> 3f51d8734cac13367c54afdee05a0be61372470e
        var res = IntArray(num)
        var l = 0
        if(max == ok1) res[l++] = 1
        if(max == ok2) res[l++] = 2
<<<<<<< HEAD
        if(max == ok3) res[l++] = 3

=======
        if(max == ok4) res[l++] = 3
        
>>>>>>> 3f51d8734cac13367c54afdee05a0be61372470e
        return res
    }
}