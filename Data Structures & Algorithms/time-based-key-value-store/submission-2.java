class TimeMap {
    HashMap<String, HashMap<Integer,String>> timeMap;
    public TimeMap() {
        timeMap=new HashMap<>();
    }
    
    public void set(String key, String value, int timeStamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key,new HashMap<>());
            
        }
        HashMap<Integer,String> subMap=timeMap.get(key);
        subMap.put(timeStamp,value);
    }
    
    public String get(String key, int timeStamp) {
        if(timeMap.containsKey(key)){
            HashMap<Integer,String> curr=timeMap.get(key);
            if(curr.containsKey(timeStamp)){
                return curr.get(timeStamp);
            }
            int prev=-1;
            String res="";
            for(int t:curr.keySet()){
                if(t<=timeStamp && t>prev){
                    prev=t;
                    res=curr.get(t);
                }
            }
            return res;
        }
        return "";
    }
}
