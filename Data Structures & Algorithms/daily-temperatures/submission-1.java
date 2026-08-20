class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n=temp.length;
        int[] res=new int[n];
        Stack<int[]> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temp[i]>stack.peek()[0]){
                int[] waitingTemp=stack.pop();
                int noOfDaysPassed=i-waitingTemp[1];
                res[waitingTemp[1]]=noOfDaysPassed;
            }
            stack.push(new int[]{temp[i],i});
        }
        return res;
    }
}
