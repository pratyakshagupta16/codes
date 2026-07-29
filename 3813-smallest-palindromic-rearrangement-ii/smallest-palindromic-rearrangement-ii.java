import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int halfLen = n / 2;

        int[] totalFreq = new int[26];
        for (int i = 0; i < n; i++) {
            totalFreq[s.charAt(i) - 'a']++;
        }

        int[] freq = new int[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = totalFreq[i] / 2;
        }

        char midChar = 0;
        if (n % 2 != 0) {
            for (int i = 0; i < 26; i++) {
                if (totalFreq[i] % 2 != 0) {
                    midChar = (char) ('a' + i);
                    break;
                }
            }
        }

        StringBuilder firstHalf = new StringBuilder();
        int remainingLen = halfLen;

        for (int pos = 0; pos < halfLen; pos++) {
            boolean found = false;

            for (int c = 0; c < 26; c++) {
                if (freq[c] == 0) continue;

                freq[c]--;
                long count = countPermutations(freq, remainingLen - 1, k);

                if (count >= k) {
                    firstHalf.append((char) ('a' + c));
                    remainingLen--;
                    found = true;
                    break;
                } else {
                    k -= count;
                    freq[c]++;
                }
            }

            if (!found) {
                return "";
            }
        }

        StringBuilder fullPalindrome = new StringBuilder(firstHalf);
        if (n % 2 != 0) {
            fullPalindrome.append(midChar);
        }
        fullPalindrome.append(new StringBuilder(firstHalf).reverse());

        return fullPalindrome.toString();
    }

    private long countPermutations(int[] freq, int totalLen, long maxK) {
        if (totalLen == 0) return 1;

        long totalPermutations = 1;
        int rem = totalLen;

        for (int f : freq) {
            if (f == 0) continue;
            // Calculate nCr(rem, f)
            long nCr = nCr(rem, f, maxK);
            totalPermutations = capMult(totalPermutations, nCr, maxK);
            if (totalPermutations > maxK) return maxK + 1;
            rem -= f;
        }

        return totalPermutations;
    }

    private long nCr(int n, int r, long maxK) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (r > n / 2) r = n - r;

        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i; // Correct step-by-step combination
            if (res > maxK) return maxK + 1;
        }
        return res;
    }

    private long capMult(long a, long b, long maxK) {
        if (a == 0 || b == 0) return 0;
        if (a > maxK / b) return maxK + 1;
        return a * b;
    }
}