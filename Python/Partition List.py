# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
    def partition(self, head, x):
        dummy = ListNode(0)
        dummy.next = head
        head = dummy
        pre  = None
        
        while head.next != None:
            if head.next.val < x and pre != None:
                tmp = head.next
                head.next = head.next.next
                tmp.next = pre.next
                pre.next = tmp
                pre = tmp
                continue
            elif head.next.val >= x and pre == None:
                pre = head
            head = head.next
        
        return dummy.next