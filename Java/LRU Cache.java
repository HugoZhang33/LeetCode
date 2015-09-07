public class LRUCache {
    private class ListNode {
        ListNode pre;
        ListNode next;
        int key;
        int value;
        
        public ListNode(int key, int value) {
            this.key   = key;
            this.value = value;
        }
    }
    
    private int cap = 0;
    private HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    private ListNode head = new ListNode(-1, -1);
    private ListNode tail = new ListNode(-1, -1);
    
    
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            remove(node);
            addFirst(node);
            return node.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) { // set
            ListNode node = map.get(key);
            node.value = value;
            remove(node);
            addFirst(node);
        } else { // add
            if (map.size() >= this.cap) {
                ListNode lastNode = tail.pre;
                remove(lastNode);
                map.remove(lastNode.key);
            }
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            addFirst(newNode);
        }
    }
    
    private void remove(ListNode node) {
        if (node == null)
            return;
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void addFirst(ListNode node) {
        if (node == null)
            return;
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
    }
}