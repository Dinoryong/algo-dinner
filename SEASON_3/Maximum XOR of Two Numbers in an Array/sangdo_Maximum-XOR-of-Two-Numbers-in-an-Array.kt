class Node(var v: Int=0, var left:Node? = null, var right: Node? = null)

/*
이진트리를 활용한다.
높은 비트에서부터 한 수 a에 대해서 x비트가 1이면 다른 수 b는 x비트가 0이어야 가장 큰 수가된다.
만약, x비트가 0인 수가 없다면, x비트가 1인 수 중에서 x+1번 비트를 xor를 했을때 가장 큰 수를 찾으면 되는 방식이다.
*/
class Solution {
    fun findMaximumXOR(nums: IntArray): Int {
        var p = Node(0)
        for(v in nums) {
            var cur = p
            for(i in 31 downTo 0) {
                var b = 1 shl i
                if((b and v)!= 0) {
                    if(cur.right == null){
                        cur.right = Node(v)
                    }
                    cur = cur.right!!
                }
                else {
                    if(cur.left == null){
                        cur.left = Node(v)
                    }
                    cur = cur.left!!
                }
            }
        }
        var res = 0
        for(v in nums) {
            var cur = p
            for(i in 31 downTo 0){
                var b = (1 shl i)
                
                if((b and v) == 0) {
                    cur = if(cur.right == null) cur.left!! else cur.right!!
                }
                else {
                    cur = if(cur.left == null) cur.right!!  else cur.left!!
                }
            }
            res = Math.max(res, v xor cur.v)
        }
        return res      
    }
}
