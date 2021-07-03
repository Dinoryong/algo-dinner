import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.*


fun main() {
//    val path = "C:\\Users\\SD\\IdeaProjects\\HelloKotlin\\src\\Text.txt"
//    System.setIn(FileInputStream(path))

    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var n = Integer.parseInt(st.nextToken())
    var m = Integer.parseInt(st.nextToken())
    var adj = Array(n+1){ArrayList<Int>()}
    var child = 0
    for(i in 2 .. n){
        st= StringTokenizer(br.readLine())
        var a= Integer.parseInt(st.nextToken())
        var b = Integer.parseInt(st.nextToken())
        adj[a].add(b)
        adj[b].add(a)
    }
    var Q: Queue<Int> = LinkedList()
    Q.add(1)
    var chk = Array<Boolean>(n+1){false}
    chk[1] = true
    while(Q.isNotEmpty()){
        var now = Q.poll()
        if(adj[now].size == 1 && now != 1) {
            child++
            continue
        }
        for(nxt in adj[now]){
            if(chk[nxt]) continue
            chk[nxt] = true
            Q.add(nxt)
        }
    }
    println(m.toDouble()/child)
}
