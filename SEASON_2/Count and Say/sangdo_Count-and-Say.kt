class Solution {
    fun countAndSay(n: Int): String {
        return if(n == 1) "1" else {
            var res = countAndSay(n-1)
            var idx = 0
            var prev = res[0]
            var ret = StringBuilder()
            while(idx < res.length){
                var cnt = 0
                while(idx < res.length && res[idx] == prev) {cnt++; idx++}
                ret.append(cnt.toString())
                ret.append(prev)
                if(idx != res.length) prev = res[idx]
            }
            println(ret.toString())
            ret.toString()
        }   
    }
}
