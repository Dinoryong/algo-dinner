class Node {
    var str : String
    var next : Node?
    var prev : Node?
    init() {
        str = ""
        self.next = nil; self.prev = nil
    }
    init(_ str: String, _ prev : Node?, _ next: Node?) {
        self.str = str
        self.prev = prev
        self.next = next
    }
    func pop() {
        if prev != nil {
            prev?.next = next
        }
        if next != nil {
            next?.prev = prev
        }
    }
}

func solution(_ cacheSize:Int, _ cities:[String]) -> Int {
    var map : [String : Node] = [String: Node]()
    var head : Node = Node()
    var tail : Node = Node("", head, nil)
    
    if cacheSize == 0 {
        return cities.count * 5
    }
    
    var LRUQueueLen = 0
    var ans = 0
    for c in cities {
        let city = c.uppercased()
        var node : Node = Node(city, nil, nil)
        
        // 큐가 다 차기 전까진 일단 다 넣는다.
        if LRUQueueLen < cacheSize {
            if let v = map[city] {// 하지만 만약 캐시 큐에 존재한다면? HIT!
                v.pop()
                v.next = tail
                v.prev = tail.prev
                map[city] = v
                
                tail.prev?.next = v
                tail.prev = v
                ans += 1
            }else{//캐시 큐에 존재하지 않으면! MISS!
                node.next = tail
                node.prev = tail.prev
                map[city] = node
                
                tail.prev?.next = node
                tail.prev = node
                LRUQueueLen += 1
                ans += 5
            }
        }else{// 큐가 다 찼다면!!
            if let v = map[city] {// 만약 이미 나왔던 것일 경우, 1. 현재 큐에 있거나, 2. 큐에 없거나 <- pop하면 양 옆이 nil임..
                if v.next == nil, v.prev == nil {
                    let cit: String = head.next?.str ?? ""
                    head.next?.pop()
                    map[cit] = Node(cit, nil, nil)
                    
                    node.next = tail
                    node.prev = tail.prev
                    map[city] = node
                    
                    tail.prev?.next = node
                    tail.prev = node
                    ans += 5//캐시 미스
                }else{
                    // 이미 존재하는 경우에 대해!
                    v.pop()
                    v.next = tail
                    v.prev = tail.prev
                    map[city] = v
                    
                    tail.prev?.next = v
                    tail.prev = v
                    ans += 1
                }
            }else{
                let cit: String = head.next?.str ?? ""
                head.next?.pop()
                map[cit] = Node(cit, nil, nil)
                
                node.next = tail
                node.prev = tail.prev
                map[city] = node
                
                tail.prev?.next = node
                tail.prev = node
                ans += 5//캐시 미스
            }
        }
    }
    
    return ans
}
