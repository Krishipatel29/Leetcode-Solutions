class Solution {
    public int findDuplicate(int[] nums) {
        // Start both pointers from index 0
        int slow = 0;
        int fast = 0;

        // Finding the meeting point
        while(true){
            slow = nums[slow]; // Move 1 step
            fast = nums[fast]; // Move 2 steps
            fast = nums[fast];

            // Cycle found
            if(slow == fast){

                // Move slow back to the starting point
                slow = 0;

                // Find the starting point of the cycle
                while(slow != fast){

                    // Move both one step
                    slow = nums[slow];
                    fast = nums[fast];
                }

                // Cycle starting point - duplicate number
                return slow;
            }
        } 
    }
}

// TC : o(N)
// SC : o(1)