import java.util.*;

class Solution {
    public String smallestNumber(String num, long t) {
        // 1. Prime factorize t into counts of 2, 3, 5, 7
        long temp = t;
        int c2 = 0, c3 = 0, c5 = 0, c7 = 0;
        while (temp % 2 == 0) { temp /= 2; c2++; }
        while (temp % 3 == 0) { temp /= 3; c3++; }
        while (temp % 5 == 0) { temp /= 5; c5++; }
        while (temp % 7 == 0) { temp /= 7; c7++; }

        if (temp > 1) return "-1"; // Prime factors > 7 are invalid

        int n = num.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) digits[i] = num.charAt(i) - '0';

        int minLenNeeded = getMinDigitsNeeded(c2, c3, c5, c7);

        // Pre-calculate running factor counts for prefixes of num without zeros
        int[] p2 = new int[n + 1];
        int[] p3 = new int[n + 1];
        int[] p5 = new int[n + 1];
        int[] p7 = new int[n + 1];
        int zeroIdx = -1;

        for (int i = 0; i < n; i++) {
            p2[i + 1] = p2[i];
            p3[i + 1] = p3[i];
            p5[i + 1] = p5[i];
            p7[i + 1] = p7[i];
            if (digits[i] == 0) {
                if (zeroIdx == -1) zeroIdx = i;
                break;
            }
            int d = digits[i];
            while (d % 2 == 0) { p2[i + 1]++; d /= 2; }
            while (d % 3 == 0) { p3[i + 1]++; d /= 3; }
            if (d == 5) p5[i + 1]++;
            if (d == 7) p7[i + 1]++;
        }

        // Try to match prefix up to length i (from n down to 0)
        int maxI = (zeroIdx == -1) ? n : zeroIdx;
        for (int i = maxI; i >= 0; i--) {
            int req2 = Math.max(0, c2 - p2[i]);
            int req3 = Math.max(0, c3 - p3[i]);
            int req5 = Math.max(0, c5 - p5[i]);
            int req7 = Math.max(0, c7 - p7[i]);

            // Case A: Exact length prefix matches
            if (i == n) {
                if (getMinDigitsNeeded(req2, req3, req5, req7) == 0) {
                    return num;
                }
                continue;
            }

            // Case B: Try replacing digit at position i with a strictly larger digit d
            int startD = digits[i] + 1;
            for (int d = startD; d <= 9; d++) {
                int nr2 = Math.max(0, req2 - countFactor(d, 2));
                int nr3 = Math.max(0, req3 - countFactor(d, 3));
                int nr5 = Math.max(0, req5 - (d == 5 ? 1 : 0));
                int nr7 = Math.max(0, req7 - (d == 7 ? 1 : 0));

                int remLen = n - 1 - i;
                int needed = getMinDigitsNeeded(nr2, nr3, nr5, nr7);

                if (needed <= remLen) {
                    StringBuilder sb = new StringBuilder(num.substring(0, i));
                    sb.append(d);
                    sb.append(buildSmallestSuffix(remLen, nr2, nr3, nr5, nr7));
                    return sb.toString();
                }
            }
        }

        // Case C: Length needs to be expanded
        int newLen = Math.max(n + 1, minLenNeeded);
        return buildSmallestSuffix(newLen, c2, c3, c5, c7);
    }

    private int countFactor(int d, int p) {
        int cnt = 0;
        while (d > 0 && d % p == 0) {
            cnt++;
            d /= p;
        }
        return cnt;
    }

    private int getMinDigitsNeeded(int c2, int c3, int c5, int c7) {
        int c8 = c2 / 3; c2 %= 3;
        int c9 = c3 / 2; c3 %= 2;

        int extra = 0;
        if (c2 == 2 && c3 == 1) extra = 2;      // digits 2 and 6 (2 * 6 = 12)
        else if (c2 == 2) extra = 1;            // digit 4
        else if (c2 == 1 && c3 == 1) extra = 1; // digit 6
        else if (c2 == 1) extra = 1;            // digit 2
        else if (c3 == 1) extra = 1;            // digit 3

        return c8 + c9 + c5 + c7 + extra;
    }

    private String buildSmallestSuffix(int len, int c2, int c3, int c5, int c7) {
        int c8 = c2 / 3; c2 %= 3;
        int c9 = c3 / 2; c3 %= 2;

        int c6 = 0, c4 = 0, c2_digit = 0, c3_digit = 0;

        if (c2 == 2 && c3 == 1) {
            c6 = 1; c2_digit = 1; // digits 2 and 6 (product 12)
        } else if (c2 == 2) {
            c4 = 1;
        } else if (c2 == 1 && c3 == 1) {
            c6 = 1;
        } else if (c2 == 1) {
            c2_digit = 1;
        } else if (c3 == 1) {
            c3_digit = 1;
        }

        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < c2_digit; i++) digits.add(2);
        for (int i = 0; i < c3_digit; i++) digits.add(3);
        for (int i = 0; i < c4; i++) digits.add(4);
        for (int i = 0; i < c5; i++) digits.add(5);
        for (int i = 0; i < c6; i++) digits.add(6);
        for (int i = 0; i < c7; i++) digits.add(7);
        for (int i = 0; i < c8; i++) digits.add(8);
        for (int i = 0; i < c9; i++) digits.add(9);

        // Pad with '1's from the front to reach target length
        StringBuilder sb = new StringBuilder();
        int onesNeeded = len - digits.size();
        for (int i = 0; i < onesNeeded; i++) sb.append('1');

        Collections.sort(digits);
        for (int d : digits) sb.append(d);

        return sb.toString();
    }
}