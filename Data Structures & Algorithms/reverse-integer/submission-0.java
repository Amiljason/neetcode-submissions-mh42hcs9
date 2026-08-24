class Solution {
    final int min=-2147483648;
    final int max=2147483647;
    public int reverse(int x) {
        int res=0;
        while(x!=0){
            int digit=x%10;
            x=x/10;
           if((res)>max/10||(res==max/10 && digit>7)) return 0;
           if((res)<min/10||(res==min/10 && digit<-8)) return 0;
           else{
            res=(res*10)+digit;
           }
        }
        return res;  
    }
}
