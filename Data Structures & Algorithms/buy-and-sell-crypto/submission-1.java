class Solution {
    public int maxProfit(int[] prices) {
        int l=0,r=1,n=prices.length;
        int profit=Integer.MIN_VALUE;
        while(r<n){
            int diff=prices[r]-prices[l];
            profit=Math.max(diff,profit);
            if(prices[l]>prices[r]){
                l=r;
                r++;
            }else{
                r++;
            }
        }
        return profit>0?profit:0;
    }
}
