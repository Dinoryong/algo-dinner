class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        
        while(cur!=null){
            Node curr = new Node(cur.val);
            map.put(cur,curr);
            cur = cur.next;
        }

        cur = head;
        
        while(cur!=null){
            Node curr = map.get(cur);
            curr.next = map.get(cur.next);
            curr.random = map.get(cur.random);
            cur = cur.next;
        }
        
        return map.get(head);
    }
}