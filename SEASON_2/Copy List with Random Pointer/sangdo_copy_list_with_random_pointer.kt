class Solution {
    fun copyRandomList(node: Node?): Node? {
        var head = node
        if(head == null) return null
        while(head != null){
            var nxt = head.next?.let{it} ?: null
            var newNode = Node(head.`val`)
            newNode!!.next = nxt
            newNode!!.random = head.random
            head!!.next = newNode
            head = nxt
        }
        var newHead = node!!.next
        var newNode = newHead
        while(newNode != null) {
            var nxt = newNode.next?.let{it.next} ?:null
            newNode!!.random = newNode!!.random?.let{it.next} ?: null
            newNode = nxt
        }
        newNode = newHead
        head = node
        while(newNode!=null) {
            head!!.next = newNode!!.next
            newNode.next = newNode.next?.let{it.next}?: null
            head = head.next
            newNode = newNode.next
        }
        return newHead
    }
}
