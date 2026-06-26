/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        // edge case: an empty list, or a single node list
        if (head == null || head.next == null) {return false;}
        
        ListNode ptr_slow = head;
        ListNode ptr_fast = head.next;
        while (ptr_fast != null && ptr_fast.next != null) {
            if (ptr_fast.equals(ptr_slow)) {
                return true;
            }
            ptr_slow = ptr_slow.next;
            ptr_fast = ptr_fast.next.next;
        }
        return false;
    }
}

/*

{val:1 , next: -} -> {val:2 , next: -} -> {val:3 , next: -} -> {val:4 , next: -}
                      ^_______________________________________________________|
map: {
    {val:1 , next: -} -> {val:2 , next: -} -> {val:3 , next: -} -> {val:4 , next: -}: 1,
    {val:2 , next: -} -> {val:3 , next: -} -> {val:4 , next: -}: 2,
    {val:3 , next: -} -> {val:4 , next: -}: 3,
    {val:4 , next: -}: 4
}
                     
*/

