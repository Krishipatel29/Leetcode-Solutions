class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while(i < j){
            if(numbers[i] + numbers[j] > target){
                j--;
            }
            else if(numbers[i] + numbers[j] < target){
                i++;
            }
            else{
                return new int[] { i+1,j+1 };
            }
        }
        throw new IllegalArgumentException("No Result Found!");
    }
}



/* 

DRY RUN EXAMPLE: 
target = 9

           0  1  2  3  4   5   6   (idx)
numbers = [1, 3, 4, 5, 7, 10, 11] 

Step 1:  i                   j   ->  1 + 11 = 12 (12 > 9)   ->  j--
Step 2:  i               j       ->  1 + 10 = 11 (11 > 9)   ->  j--
Step 3:  i           j           ->  1 +  7 =  8 ( 8 < 9)   -> i++
Step 4:     i        j           ->  3 +  7 = 10 (10 > 9)   -> j--
Step 5:     i     j              ->  3 +  5 =  8 ( 8 < 9)   -> i++
Step 6:        i  j              ->  4 +  5 =  9 ( 9 == 9)  -> return [2+1, 3+1] -> [3, 4]


*/