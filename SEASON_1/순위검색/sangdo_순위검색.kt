import java.util.*

class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer = IntArray(query.size)
        var hash = hashMapOf("cpp" to 1, "java" to 2, "python" to 4, "backend" to 1, "frontend" to 2, "junior" to 1, "senior" to 2, "chicken" to 1, "pizza" to 2, "-" to 3)
        var users = Array<ArrayList<Int>>(1 shl 9){ArrayList()}
        var scores = IntArray(info.size)
        
       	for(i in info.indices) {
            var d = info[i].split(" ")
            var language = hash[d[0]]!!
            var work = hash[d[1]]!!
            var year = hash[d[2]]!!
            var like = hash[d[3]]!!
            scores[i] = d[4].toInt()
            
            users[(language) + (work shl 3) + (year shl 5) + (like shl 7)].add(i)
            users[(7) + (work shl 3) + (year shl 5) + (like shl 7)].add(i)
            users[(language) + (3 shl 3) + (year shl 5) + (like shl 7)].add(i)
            users[(7) + (3 shl 3) + (year shl 5) + (like shl 7)].add(i)
            users[(language) + (work shl 3) + (3 shl 5) + (like shl 7)].add(i)
            users[(7) + (work shl 3) + (3 shl 5) + (like shl 7)].add(i)
            users[(language) + (3 shl 3) + (3 shl 5) + (like shl 7)].add(i)
            users[(7) + (3 shl 3) + (3 shl 5) + (like shl 7)].add(i)
            users[(language) + (work shl 3) + (year shl 5) + (3 shl 7)].add(i)
            users[(7) + (work shl 3) + (year shl 5) + (3 shl 7)].add(i)
            users[(language) + (3 shl 3) + (year shl 5) + (3 shl 7)].add(i)
            users[(7) + (3 shl 3) + (year shl 5) + (3 shl 7)].add(i)
            users[(language) + (work shl 3) + (3 shl 5) + (3 shl 7)].add(i)
            users[(7) + (work shl 3) + (3 shl 5) + (3 shl 7)].add(i)
            users[(language) + (3 shl 3) + (3 shl 5) + (3 shl 7)].add(i)
            users[(7) + (3 shl 3) + (3 shl 5) + (3 shl 7)].add(i)
        }
        for(i in 0 until (1 shl 9)){
            users[i].sortWith(Comparator{i,j->scores[i] - scores[j]})
        }
            
        for(i in query.indices) {
            var q = query[i]
            var s = q.split(" and ")
            var language = if(s[0] == "-") 7 else hash[s[0]]!!
            var work = hash[s[1]]!!
            var year = hash[s[2]]!!
            var s2 = s[3].split(" ")
            var like = hash[s2[0]]!!
            var score = s2[1].toInt()
            var bit = language + (work shl 3) + (year shl 5) + (like shl 7)
            var l = 0
            var r = users[bit].size
            //users[bit].forEach{print("$it ")}
            //println()
            while(l < r){
                var m = (l+r)/2
                if(scores[users[bit][m]] < score) l = m+1
                else r = m
            }
           	answer[i] = users[bit].size - l
            //println("$language $work $year $like $score")
        }
        return answer
    }
}
