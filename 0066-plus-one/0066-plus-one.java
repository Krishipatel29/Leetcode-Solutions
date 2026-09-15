class Solution {
    public int[] plusOne(int[] digits) { 
        // start from last digit
        for(int i=digits.length-1; i >= 0; i--){
            // if digit is 9, it becomes 0 and carry goes to the left
            if(digits[i]==9){
                digits[i]=0;
            }
            // if digit is not 9 , add 1 and return
            else{
                digits[i]=digits[i]+1;
                return digits;
            }
        }
        // if all digits are 9 , we need extra size of array
        int[] newDigits = new int[digits.length + 1];

        // first digit becomes 1
        newDigits[0] = 1;


        return newDigits;    
    }
}

//tc: o(n)
//sc: o(n) because worst case all digits are 0