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

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Slow moves one step, fast moves two steps
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow reaches the middle node
        return slow;
    }
}

// TC : O(N)
// SC : O(1)