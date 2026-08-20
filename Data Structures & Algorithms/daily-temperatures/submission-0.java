class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n=temp.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int curr=temp[i];
            int count=0;
            for(int j=i+1;j<n;j++){
                if(temp[j]>curr){
                    res[i]=count+1;
                    break;
                }
                else count+=1;
            }
        }
        return res;
    }
}
