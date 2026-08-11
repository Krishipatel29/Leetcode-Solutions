class Solution {

    // Helper function: returns sum of squares of digits
    private int helperFun(int n) {
        /*
             Dry Run: n = 19
        
             digit = 19 % 10 = 9
             sum = 0 + 9*9 = 81
             n = 19 / 10 = 1
        
             digit = 1 % 10 = 1
             sum = 81 + 1*1 = 82
             n = 1 / 10 = 0
        
             return 82
        */

        int sum = 0;
        {
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            return sum;
        }
    }

    public boolean isHappy(int n) {

        // Start both pointers from n
        int slow = n;
        int fast = n;

        while (true) {

            slow = helperFun(slow); // Slow moves one step
            fast = helperFun(helperFun(fast)); // Fast moves two steps

            // If they meet, a cycle exists
            if (slow == fast) {

                // They must meet at 1 for a happy number
                return slow == 1;
            }
        }

    }
}

// Time c: O(log n)
// Space c: o(1)