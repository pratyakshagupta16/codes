class Solution {
    public int maxProduct(int n) {
       
       int max = 0;
       int max2 = 0;

       while(n>0){
        int digit = n%10;

        if(digit>=max){
        max2 = max;
        max= digit; 
       }
       else if(digit>max2){
        max2 = digit;
       }
       n/=10;
       }

       
    return max*max2;

        
    }
}