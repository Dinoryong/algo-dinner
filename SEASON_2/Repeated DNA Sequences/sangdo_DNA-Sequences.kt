class Solution {
    fun findRepeatedDnaSequences(s: String): List<String> {
        var hash = Array<Int>(1048576){0}
        var res = ArrayList<String>()
        var conv = IntArray(256)
        conv['A'.toInt()] = 0
        conv['C'.toInt()] = 1
        conv['G'.toInt()] = 2
        conv['T'.toInt()] = 3
        var chk = 0
        if(s.length<10) return res
        for(i in 0 until 10) {
            chk = (chk shl 2) + conv[s[i].toInt()]
        }
        hash[chk]++
        for(j in 10 .. s.lastIndex){
            chk = chk.shl(2) - conv[s[j-10].toInt()].shl(20) + conv[s[j].toInt()]
            hash[chk]++
            if(hash[chk] == 2) res.add(s.substring(j-9,j+1))
        }
        return res
    }
}
