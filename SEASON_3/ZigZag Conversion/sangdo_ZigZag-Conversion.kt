class Solution {
    fun convert(s: String, numRows: Int): String {
        if(numRows == 1) return s
        var zigzags= Array<IntArray>(numRows){IntArray(1000){0}}
        var dr = intArrayOf(1,-1)
        var dc = intArrayOf(0,1)
        var d = 0
        var cnt = 0
        var last = 0
        var change = numRows -1
        zigzags[0][0] = s[0].toInt()
        var i = if(cnt == change) 0 else 1
        var j = if(cnt == change) 1 else 0
        
        for(c in s.substring(1,s.length)){
            zigzags[i][j] = c.toInt()
            last = j
            cnt++
            if(cnt == change) {
                cnt = 0
                d = d xor 1
            }
            i += dr[d]
            j += dc[d]
        }
        var res = StringBuilder()
        for(i in 0 until numRows){
            for(j in 0 .. last) {
                if(zigzags[i][j] != 0) {
                   res.append(zigzags[i][j].toChar())
                }
            }
        }
        return res.toString()
    }
}
