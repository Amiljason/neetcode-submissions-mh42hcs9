class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       int n=position.length;
       int fleet=0;
       double prevTime=0;
       Integer[] cars=new Integer[n];
       for(int i=0;i<n;i++){
        cars[i]=i;
       }
       Arrays.sort(cars, (a, b) -> position[b] - position[a]);
       for(int i:cars){
        double time=(double)(target-position[i])/speed[i];
        if(time>prevTime){
            fleet++;
            prevTime=time;
        }
       }
       return fleet;
    }
}
