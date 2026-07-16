import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int maxEl = -1;
        
        // 1. Calculate the prefix GCD
        for (int i = 0; i < n; i++) {
            maxEl = Math.max(maxEl, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxEl);
        }
        
        // 2. Sort the prefix GCD array
        Arrays.sort(prefixGcd);
        
        // 3. Two-pointer technique to sum the GCD of pairs
        long result = 0;
        int i = 0;
        int j = n - 1;
        
        while (i < j) {
            result += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }
        
        return result;
    }

    // Helper method to compute GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
