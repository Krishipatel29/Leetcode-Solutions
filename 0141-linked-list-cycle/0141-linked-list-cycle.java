/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        // Both are start from head (1st node)
        ListNode slow = head;
        ListNode fast = head;

        // Continue while fast can move
        while (fast != null && fast.next != null) {

            // Slow moves one step, fast moves two steps
            slow = slow.next;
            fast = fast.next.next;

            // If they meet, a cycle exists
            if (fast == slow) {
                return true;
            }
        }

        // Fast reached the end, so no cycle
        return false;
    }
}

//TC : O(N)
//SC : O(1)