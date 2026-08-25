class Solution {
    HashMap<Character,Integer> map=new HashMap<>();
    PriorityQueue<Character> max=new PriorityQueue<>((a,b)->Integer.compare(map.get(b),map.get(a)));
    public int leastInterval(char[] tasks, int n) {
        for(char c:tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        max.addAll(map.keySet());
        StringBuilder s=new StringBuilder();
    
        while(!max.isEmpty()){
            int gap=n+1;
            List<Character> used=new ArrayList<>();
            while(gap>0 && !max.isEmpty()){
                char curr=max.poll();
                s.append(curr);
                map.put(curr, map.get(curr)-1);
                if(map.get(curr)>0){
                    used.add(curr);
                }   
                gap--;
            }
            for(char c:used){
                max.offer(c);
            }
            if(!max.isEmpty()){
                while(gap>0){
                    s.append('0');
                    gap--;
                }
            }
        }
        return s.length();
    }
}

