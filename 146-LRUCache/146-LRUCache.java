class LRUCache {
    class DLLNode {
        int key, val;
        DLLNode prev, next;

        public DLLNode(int k, int v) {
            key = k;
            val = v;
        }
    }

    class DLL {
        DLLNode head, tail;

        public DLL() {
            head = tail = null;
        }

        public void add(DLLNode node) {
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        public void remove(DLLNode node) {
            if (node == head && node == tail) { // Only one node
                head = tail = null;
            } else if (node == head) { // Remove head
                head = head.next;
                head.prev = null;
            } else if (node == tail) { // Remove tail
                tail = tail.prev;
                tail.next = null;
            } else { // Remove middle node
                DLLNode prev = node.prev;
                DLLNode next = node.next;
                if(prev != null)
                    prev.next = next;

                if(next != null)
                    next.prev = prev;
            }
            node.prev = node.next = null; // Clean up
        }
    }

    int count;
    int max;
    HashMap<Integer, DLLNode> map;
    DLL dll;

    public LRUCache(int capacity) {
        dll = new DLL();
        count = 0;
        max = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            dll.remove(node);
            dll.add(node); 

            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);

            dll.remove(node);
            node.val = value;
            dll.add(node);
        }else{
            DLLNode nn = new DLLNode(key, value);
            map.put(key, nn);

            dll.add(nn);
            count++;
        }

        if(count > max){
            DLLNode lru = dll.head;
            map.remove(lru.key);
            dll.remove(lru);
            count--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */