class Solution {
    func copyRandomList(_ head: Node?) -> Node? {
        if head == nil { 
            return nil 
        }
        var map: [Node : Node] = [:]
        var old = head
        var current:Node? = Node(0)

        while old != nil {
            current?.val = old!.val
            map[old!] = current
            if old?.random != nil {
                current?.random = map[old!.random!] ?? Node (old!.random!.val)
                map[old!.random!] = current?.random
            }
            old = old?.next
            if old != nil {
                current?.next = map[old!] ?? Node(0)
                current = current?.next
            }
            
        }
        return map[head ?? Node(0)]
    }
}
