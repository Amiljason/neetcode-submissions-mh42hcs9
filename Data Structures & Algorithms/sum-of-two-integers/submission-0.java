class Solution {
    public int getSum(int a, int b) {
        int result=0;
        int carry=0;
        int mask=0xFFFFFFFF;

        for(int i=0;i<32;i++){
            int aBit=(a>>i)&1;//extracting ith bit
            int bBit=(b>>i)&1;
            int sumBit=aBit^bBit^carry;
            carry=(aBit+bBit+carry);
            if(carry>=2){
                carry=1;
            }else carry=0;

            if(sumBit!=0){
                result|=(1<<(i));
            }
        }
        if(result>0x7FFFFFFF) result= ~(result^mask);
        return result;
    }
}
