class Solution {
    public boolean isHappy(int n) {
        int sum=0;
        HashSet<Integer> set=new HashSet<>();
        while(sum!=1){
            List<Integer> l=new ArrayList<>();
            while(n!=0){
                int digit=n%10;
                n=n/10;
                l.add(digit*digit);
            }
            for(int i:l){
                sum+=i;
            }
            if(sum==1) return true;
            else{
                if(set.contains(sum)) return false;
                n=sum;
                set.add(n);
                sum=0;
            }
        }
        return false;
    }
}
