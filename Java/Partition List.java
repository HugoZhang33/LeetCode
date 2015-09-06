/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode pre = null;
        
        while (head.next != null) {
            if (head.next.val < x && pre != null) {
                ListNode tmp = head.next;
                head.next = head.next.next;
                tmp.next = pre.next;
                pre.next = tmp;
                pre = tmp;
                continue;
            } else if (head.next.val >= x && pre == null) {
                pre = head;
            }
            head = head.next;
        }
        
        return dummy.next;
    }
}