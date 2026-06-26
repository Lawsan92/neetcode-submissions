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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode mergedList = new ListNode(0);
        ListNode curNode = mergedList;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curNode.next = list1; 
                list1 = list1.next;
            } else {
                curNode.next = list2;
                list2 = list2.next;
            }
            curNode = curNode.next;
        }

        if (list1 != null) {
            curNode.next = list1; 
        } else {
            curNode.next = list2; 
        }
        return mergedList.next;
    }
}

/*

list1: 1 -> 2 -> 4
list2: 1 -> 3 -> 5 
merged_list = list1, merged_list.next = list2: 1 -> 1 -> 3 -> 5
curNode = merged_list.next


list1 = list1.next => 2 -> 4
list2 = list2.next => 3 -> 5

ml   cn
v    v
1 -> 1 -> 3 -> 5

curNode.next = list_1

ml   cn
v    v
1 -> 1 -> 2 -> 4

curNode = curNode.next

ml        cn
v         v
1 -> 1 -> 2 -> 4

curNode.next = list_2

ml        cn
v         v
1 -> 1 -> 2 -> 3 -> 5

curNode = curNode.next

ml             cn
v              v
1 -> 1 -> 2 -> 3 -> 5

---------------------------
list1 = list1.next => 4
list2 = list2.next => 5

curNode.next = list_1

ml             cn
v              v
1 -> 1 -> 2 -> 3 -> 4

curNode = curNode.next

ml                  cn
v                   v
1 -> 1 -> 2 -> 3 -> 4


curNode.next = list_2

ml                       cn
v                        v
1 -> 1 -> 2 -> 3 -> 4 -> 5

curNode = curNode.next

*/

