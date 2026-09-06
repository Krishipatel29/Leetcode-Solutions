class Solution {
    public int reverse(int x) {
        int ans = 0;

        while(x != 0){
            int digit = x % 10;

            // Check Integer overflow or not

            // Positive Side
            if(ans > Integer.MAX_VALUE / 10  || (ans == Integer.MAX_VALUE / 10 && digit > 7)){
                return 0;   
            }

            // Negative Side
            if(ans < Integer.MIN_VALUE / 10  || (ans == Integer.MIN_VALUE / 10 && digit < -8)){
                return 0;   
            }

            ans = ans * 10 + digit;
            x = x / 10;
        }
        return ans;
    }
}