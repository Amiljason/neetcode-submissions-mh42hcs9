class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int pl=1,pr=1;
            int lp=0,rp=nums.length-1;
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
