import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        // Step 1: Find the maximum value in nums to define our array bounds
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Step 2: Count frequencies of each number in nums
        long[] freq = new long[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // Step 3: Count total pairs whose GCD is exactly i using inclusion-exclusion
        long[] gcdPairsCount = new long[maxVal + 1];
        
        // Iterate backwards from maxVal down to 1
        for (int i = maxVal; i >= 1; i--) {
            long totalMultiples = 0;
            
            // Count how many total elements in nums are multiples of i
            for (int j = i; j <= maxVal; j += i) {
                totalMultiples += freq[j];
            }
            
            // Number of pairs formed by these multiples (each pair has a GCD that is a multiple of i)
            long pairsWithGcdMultiple = totalMultiples * (totalMultiples - 1) / 2;
            
            // Exclude pairs whose actual GCD is a strictly larger multiple of i (e.g., 2i, 3i, 4i...)
            for (int j = 2 * i; j <= maxVal; j += i) {
                pairsWithGcdMultiple -= gcdPairsCount[j];
            }
            
            gcdPairsCount[i] = pairsWithGcdMultiple;
        }

        // Step 4: Compute prefix sums of the exact GCD pair counts
        long[] prefixSums = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSums[i] = prefixSums[i - 1] + gcdPairsCount[i];
        }

        // Step 5: Answer each query using binary search on the prefix sums array
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = binarySearch(prefixSums, queries[i]);
        }

        return answer;
    }

    // Finds the smallest GCD index where the cumulative pair count covers the requested 0-indexed query
    private int binarySearch(long[] prefixSums, long targetQuery) {
        int low = 1;
        int high = prefixSums.length - 1;
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Since queries are 0-indexed, targetQuery + 1 represents the total count needed
            if (prefixSums[mid] >= targetQuery + 1) {
                result = mid; // Potential answer, look for smaller GCD values
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
