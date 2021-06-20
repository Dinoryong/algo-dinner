class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node n1 = head;
        Node n2 = newHead;
        map.put(n1, n2);
        n1 = n1.next;
        
        while(n1 != null) {
            Node temp = new Node(n1.val);
            n2.next = temp;
            map.put(n1, temp);
            
            n1 = n1.next;
            n2 = temp;
        }
        
        n1 = head;
        n2 = newHead;
        
        while(n1 != null) {
            if(n1.random != null) {
                n2.random = map.get(n1.random); 
            } else {
                n2.random = null;
            }
            
            n1 = n1.next;
            n2 = n2.next;
        }
        
        return newHead;
    }
}
