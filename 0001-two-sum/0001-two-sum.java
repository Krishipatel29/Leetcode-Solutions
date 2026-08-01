class Solution {   // TC : o(N)    ,   SC : O(N)

    public int[] twoSum(int[] nums, int target) {

        // 1. Create a diary(Hashmap) to remember "numbers" and their "index" 
              // {number : its index}
        Map<Integer, Integer> map = new HashMap<>();
       
        // 2. Go through the array one by one
        for (int i = 0; i < nums.length; i++) {

            // 3. Find what number we need to reach the target
            int lookingFor = target - nums[i];

            // 4. Ask the diary: do you have the number we are looking for?
            if(map.containsKey(lookingFor)){

                // Found it. Return my current index and the index from the diary
                return new int[]{

                    i , map.get(lookingFor)  // CURRENT INDEX , INDEX FROM DIARY

                };
            }

            // 5. If not found, save the current "number" and its "index" for future numbers
            map.put(nums[i],i);
        }

        // 6. Emergency brake! If loop finishes and no pair is found, throw an error
        throw new IllegalArgumentException("No two sum solution found in the array!");
    }
}
/*
DRY RUN :

Input: nums = [2, 3, 7]
target = 9
Map: {}
----------------------------------step 1
 1  2  3  (index)
[2, 3, 7]
 i

 lookingFor = 9 - 2 = 7
 7 available in map ? NO

 SAVE IN MAP {2 : 0}  
            value index

----------------------------------step 2
 1  2  3  (index)
[2, 3, 7]
    i


 lookingFor = 9 - 3 = 6
 6 available in map ? NO

 SAVE IN MAP {2 : 0}
             {6 : 1}  
            value index

----------------------------------step 3
 1  2  3  (index)
[2, 3, 7]
       i


 lookingFor = 9 - 7 = 2
 2 available in map ? YES

 Where is 2? At index 0 (map.get(2))
Return current index (2) and found index (0) -> [2, 0]
*/

