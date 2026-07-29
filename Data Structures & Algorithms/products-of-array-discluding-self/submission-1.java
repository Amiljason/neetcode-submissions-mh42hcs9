class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            int lp=0,rp=n-1,pl=1,pr=1;
            while(lp!=i){
                pl*=nums[lp];
                lp++;
            }
            while(rp!=i){
                pr*=nums[rp];
                rp--;
            }
            int prod=pl*pr;
            arr[i]=prod;
        }
        return arr;
    }
}  
