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
        HashMap<ListNode, Integer> nodesMap = new HashMap<ListNode, Integer>();
        while (head != null) {
            if (nodesMap.get(head) != null) {
                return true;
            }
            nodesMap.put(head, head.val);
            head = head.next;
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

