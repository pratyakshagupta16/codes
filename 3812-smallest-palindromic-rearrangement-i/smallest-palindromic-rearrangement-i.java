import java.util.*;

public class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int halfLen = n / 2;
        
        char[] half = s.substring(0, halfLen).toCharArray();
        
        Arrays.sort(half);
        
        StringBuilder leftHalf = new StringBuilder(new String(half));
        
        String middle = (n % 2 != 0) ? String.valueOf(s.charAt(halfLen)) : "";
        
        StringBuilder rightHalf = new StringBuilder(leftHalf).reverse();
        
        return leftHalf.toString() + middle + rightHalf.toString();
    }
}