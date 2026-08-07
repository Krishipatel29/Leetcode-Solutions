class Solution {

    // TC : O(N)
    // SC : O(1)

    // Helper function to swap two elements
    public void swapNum(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {

        int i = 0;
        int k = 0;
        int j = nums.length - 1;

        // Traverse until current (k) pointer crosses right (j) pointer
        while (k <= j) {

            if (nums[k] == 1) {
                // 1 is already in correct region
                k++;
            }

            else if (nums[k] == 2) {
                // Move 2 to the right(j) side
                swapNum(nums, k, j);
                j--;

                // Don't increment k here because
                // the swapped element needs to be checked.
            }

            else {
                // Move 0 to the left(i) side
                swapNum(nums, k, i);
                i++;
                k++;
            }
        }
    }
}

// 0 .... i-1      => ALL 0
// i .... k-1      => ALL 1
// j+1 .... end    => ALL 2