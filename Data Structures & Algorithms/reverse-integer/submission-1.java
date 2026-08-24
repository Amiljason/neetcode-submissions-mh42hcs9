class Solution {
    public int reverse(int x) {
        long sum=0;
        while(x!=0){
            int digit=x%10;
            sum=sum*10+digit;
            x/=10;
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)sum;
    }
}
