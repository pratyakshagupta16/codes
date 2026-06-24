import java.util.*;

class Solution {
    
    public int minOperations(int[] nums, int[] numsDivide) {
        int g = numsDivide[0];
        for (int num : numsDivide) {
            g = gcd(g, num);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (g % nums[i] == 0) {
                return i;  
            }
        }

        return -1;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
