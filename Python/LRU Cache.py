class LRUCache(object):
    class ListNode(object):
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None
            self.pre = None

    """
    :type capacity: int
    """
    def __init__(self, capacity):
        self.cap = capacity
        self.head = self.ListNode(-1,-1)
        self.tail = self.ListNode(-1,-1)
        self.head.next = self.tail
        self.tail.pre = self.head
        self.map = {}

    """
    :rtype: int
    """
    def get(self, key):
        if key in self.map:
            node = self.map[key]
            self.remove(node)
            self.addFirst(node)
            return node.value
        else:
            return -1

    """
    :type key: int
    :type value: int
    :rtype: nothing
    """
    def set(self, key, value):
        if key in self.map:
            node = self.map[key]
            node.value = value
            self.remove(node)
            self.addFirst(node)
        else:
            if len(self.map) >= self.cap:
                node = self.tail.pre
                self.remove(node)
                del self.map[node.key]
            node = self.ListNode(key, value)
            self.addFirst(node)
            self.map[key] = node

    def remove(self, node):
        node.pre.next = node.next
        node.next.pre = node.pre

    def addFirst(self, node):
        node.pre = self.head
        node.next = self.head.next
        self.head.next = node
        node.next.pre = node