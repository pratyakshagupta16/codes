class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3) return n;
        
        // Find the most significant bit's position
        int highestBit = (int) (Math.log(n) / Math.log(2));
        
        // The number of unique XOR values is 2^(highestBit + 1)
        return 1 << (highestBit + 1);
    }
}
