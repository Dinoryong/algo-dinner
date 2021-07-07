class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var hashMap = HashMap<String,HashSet<String>>()
        for(c in clothes){
            var t = c[0]
            var k = c[1]
            if(hashMap[k] == null){
                hashMap[k] = HashSet<String>()
            }
            hashMap[k]!!.add(t)
        }
        
        var res = 1
        for((k,d) in hashMap){
            res *= d.size+1
        }
        return res-1
    }
}
