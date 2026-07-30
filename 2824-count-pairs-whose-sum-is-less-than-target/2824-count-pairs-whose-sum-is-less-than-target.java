class Solution {
    public int countPairs(List<Integer> nums, int target) {
        // Step 1: Sort the list first.
        // This gives us extreme numbers (smallest on the left, largest on the right)
        Collections.sort(nums);

        // Step 2: Set our two pointers
        int i = 0; // left pointer for the smallest numbers
        int j = nums.size() - 1; // right pointer for the largest numbers
        int count = 0; // to keep track of total valid pairs

        // We need a pair (two different elements), so loop runs until they meet
        while(i < j) {
            
            // Check if the sum of current smallest and largest is strictly less than target
            if(nums.get(i) + nums.get(j) < target) {
                
                // THE MAGIC LOGIC: If the large number at 'j' works with 'i', 
                // then all numbers before 'j' will definitely work with 'i' (since array is sorted).
                // So, we add all pairs at once using the distance (j - i).
                count = count + (j - i);
                
                // Number at 'i' is fully explored, so move to the next number
                i++;
            } 
            else {
                // The sum is too big or equal to target. 
                // The large number at 'j' is useless, so discard it and move left.
                j--;
            }
        }
        
        return count;
    }
}