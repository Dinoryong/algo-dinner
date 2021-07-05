import java.util.*

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var genre = HashMap<String, Int>()
        var genrePQ = PriorityQueue<String>{ i,j ->
            genre[j]!! - genre[i]!!
        }
        var pqHash = HashMap<String, PriorityQueue<Int>>()
        for(i in genres.indices) {
            pqHash[genres[i]]?.let{ } ?: {pqHash[genres[i]] = PriorityQueue<Int>{i,j->if(plays[i] != plays[j]) plays[j] - plays[i] else i-j}}()
            pqHash[genres[i]]!!.add(i)
            genre[genres[i]]?.let{} ?: {genre[genres[i]] = 0}()
            genre[genres[i]] =  genre[genres[i]]!! + plays[i]
        }
        
        genre.forEach{k,v -> genrePQ.add(k)}
        var res = ArrayList<Int>()
        while(genrePQ.isNotEmpty()){
            var now = genrePQ.poll()
            var cnt = Math.min(2, pqHash[now]!!.size)
            while(cnt!=0){
                res.add(pqHash[now]!!.poll())
                cnt--
            }
        }
        
        return res.toIntArray()
    }
}
