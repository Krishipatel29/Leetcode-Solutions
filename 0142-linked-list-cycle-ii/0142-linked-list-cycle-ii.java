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
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Find the meeting point
        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){

                // Move slow to head
                slow = head;

                // Find the starting node of the cycle
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                // Return the starting point of cycle
                return slow;
            }
        }
        // No cycle
        return null;
    }
}

// Time c = o(n)
// Space c = o(1)