class Solution {
    fun solution(s: String): IntArray {
        var temp = s.substring(1,s.length-1).split("{")
        var arr = ArrayList<ArrayList<Int>>()
        for(s in temp){
            if(s.length > 0){
                s.split("}").forEach {
                    var a = ArrayList<Int>()
                    var t = it.split(",").forEach{
                        if(it.length != 0) a.add(it.toInt())
                    }
                    if(a.size != 0) arr.add(a)
                }
            }
        }
        arr.sortWith(Comparator{ i,j ->
            i.size - j.size
        })
        var answer = IntArray(arr.size)
        var chk = HashSet<Int>()
        for(i in arr.indices){
            for(v in arr[i]){
                if(v in chk) {
                }
                else{
                    answer[i] = v
                    chk.add(v)
                    break
                }
            }
        }
        return answer
    }
}
