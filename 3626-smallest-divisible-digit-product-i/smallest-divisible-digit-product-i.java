class Solution {
    public int smallestNumber(int n, int t) {
        int current = n;
        while (true) {
            if (digitProduct(current) % t == 0) {
                return current;
            }
            current++;
        }
    }
    
    private int digitProduct(int num) {
        int prod = 1;
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0) return 0;
            prod *= digit;
            temp /= 10;
        }
        return prod;
    }
}
