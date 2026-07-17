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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy_1 = new ListNode();
        ListNode dummy_2 = new ListNode();
        while (head != null) {
         dummy_1 = head.next;
         head.next = dummy_2.next;
         dummy_2.next = head;   
         head = dummy_1;
        }
     return dummy_2.next;   
    }
}

/*

output: 3 -> 2 -> 1 -> 0

{val: 3, next: -}-> {va: 2: next:-}->...

TreeNode dummy_1 = new TreeNode(null);
TreeNode dummy_2 = new TreeNode(null);


dummy_2
|
v
0 -> 1 -> 2 -> 3
|   ^
v   |
dummy_1

dummy_1.next = 0.next = {1}
0.next = dummy_2.next = null
dummy_2.next = {0}

0.next -> null | dummy_1.next -> 1.next -> 2.next -> 3.next
^
|
dummy_2.next

------------------------------------------------------------------------------------------
dummy_1.next = 1.next = {2}
1.next = dummy_2.next = {0}
dummy_2.next = {1}

0.next -> null | dummy_1.next -> 1.next -> 2.next -> 3.next
^
|
dummy_2.next

------------------------------------------------------------------------------------------
dummy_1.next = 2.next = {3}
2.next = dummy_2.next = {1}
dummy_2.next = {2}

2.next -> 1.next -> 0.next -> null | dummy_1.next -> 3.next
^
|
dummy_2.next

------------------------------------------------------------------------------------------
dummy_1.next = 3.next = null
3.next = dummy_2.next = {2}
dummy_2.next = {3}

3.next -> 2.next -> 1.next -> 0.next -> null | dummy_1.next -> null
^
|
dummy_2.next

*/