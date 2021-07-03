class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
       var Q:Queue<Int> = LinkedList<Int>() 
       var adj = Array<ArrayList<Int>>(numCourses){ArrayList()}
       var inorder = IntArray(numCourses)
       prerequisites.forEach{
           var a = it[0]
           var b = it[1]
           inorder[a]++
           adj[b].add(a)
       }
       for(i in 0 until numCourses){
           if(inorder[i] == 0) Q.add(i)
       }
       var res = IntArray(numCourses)
       var len = 0
       while(Q.isNotEmpty()){
           var now = Q.poll()
           res[len++] = now
           adj[now].forEach{
               inorder[it]--
               if(inorder[it] == 0) {
                   Q.add(it)
               }
           }
       }
       return if(len == numCourses) res else IntArray(0)
    }
}
