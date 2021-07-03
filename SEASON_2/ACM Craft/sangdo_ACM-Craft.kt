import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.*

fun main(){
  ////  val path = "C:\\Users\\SD\\IdeaProjects\\HelloKotlin\\src\\Text.txt"
  //  var a = System.setIn(FileInputStream(path))
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val t = st.nextToken().toInt()

    for(tc in 1 .. t) {
        st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        var k = st.nextToken().toInt()
        var buildTime = IntArray(n+1)
        var inorder = IntArray(n+1)
        var time = IntArray(n+1)
        var adj = Array(n+1){ArrayList<Int>()}
        st = StringTokenizer(br.readLine())
        for(i in 1 .. n){
            buildTime[i] = st.nextToken().toInt()
        }

        for(i in 1 .. k){
            st = StringTokenizer(br.readLine())
            var a = st.nextToken().toInt()
            var b = st.nextToken().toInt()
            adj[a].add(b)
            inorder[b]++
        }
        var Q: Queue<Int> = LinkedList()
        for(i in 1 .. n){
            if(inorder[i] == 0) Q.add(i)
        }
        st = StringTokenizer(br.readLine())
        var w = st.nextToken().toInt()
        while(Q.isNotEmpty()) {
            var now = Q.poll()
            var complete = time[now] + buildTime[now]
            if(now == w) break
            for(nxt in adj[now]){
                time[nxt] = Math.max(time[nxt], complete)
                inorder[nxt]--
                if(inorder[nxt] == 0){
                    Q.add(nxt)
                }
            }
        }
        println(time[w] + buildTime[w])
    }
}

