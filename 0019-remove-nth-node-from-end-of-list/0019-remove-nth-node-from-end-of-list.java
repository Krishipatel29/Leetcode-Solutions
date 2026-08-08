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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create Dummy node

        ListNode dummy = new ListNode(0);
        dummy.next = head;


        // Set Pointers 

        ListNode prev = dummy;
        ListNode curr = head;


        // Create Variable "t" for count jumps

        int t = 0;


        // Move current n steps ahead

        while(t < n){
            curr = curr.next;
            t++;
        }


        // Maintain the gap of 'n' between previous and current - loop for that

        while(curr!=null){
            curr = curr.next;
            prev = prev.next;
        }


        // Remove the target node

        prev.next = prev.next.next;


        // Return the actual head of the modified list    

        return dummy.next;
    }
}
//                 curr loop   prev & curr 
//                                loop
//                    \/          \/
// Time Complexity : O(n)   +   O(N)   =   O(2N) = O(N)
// Space Complexity : o(1)