/*
 
 Approach: Sort + Fix One Element + Two Pointers

 
 */
class Solution {

    // 2 SUM HELPER FUNCTION
    // For a fixed index "f", find all pairs (i, j) in the rest
    // of the array such that nums[f] + nums[i] + nums[j] == 0

    void twoSumHelper(int f, int[] nums, List<List<Integer>> res) {
        int i = f + 1;              // left pointer, starts right after fixed element
        int j = nums.length - 1;    // right pointer, starts at end of array

        while (i < j) {
            int sum = nums[f] + nums[i] + nums[j];

            if (sum > 0) {
                // sum too big -> we need a smaller number -> shrink from right
                j--;
            } else if (sum < 0) {
                // sum too small -> we need a bigger number -> grow from left
                i++;
            } else {

                // FOUND A VALID TRIPLET -> SAVE AS LIST IN "RES" (LIST OF LISTS)
                res.add(Arrays.asList(nums[f], nums[i], nums[j]));

                // move both pointers inward to look for the next possible pair
                i++;
                j--;

                // REMOVE DUPLICATES FOR I
                // skip repeated values so we don't add the same triplet again
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }

                // REMOVE DUPLICATES FOR J
                // same idea, but from the right side
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // STEP 1 - SORT THE ARRAY (required for two-pointer approach + duplicate skipping)
        Arrays.sort(nums);

        // STEP 2 - RESULT CONTAINER for all unique triplets found
        List<List<Integer>> res = new ArrayList<>();

        // STEP 3 - FIX EACH ELEMENT ONE BY ONE 
        for (int f = 0; f < nums.length; f++) {

            // array is sorted, so if the smallest number (nums[f])
            // is already positive, no triplet ahead can sum to 0 -> stop early
            if (nums[f] > 0)
                break;

            // REMOVE DUPLICATES FOR THE FIXED ELEMENT
            // f == 0 -> first element, nothing to compare, always process
            // nums[f] != nums[f-1] -> skip if same as previous fixed element
            //                          (would just regenerate the same triplets)
            if (f == 0 || nums[f] != nums[f - 1]) {
                twoSumHelper(f, nums, res);
            }
        }

        return res;
    }
}

// TC : o(n log n  +  n^2)   
//           ^         ^
//        sorting     f loop + 2 pointers

// SC : (log n)