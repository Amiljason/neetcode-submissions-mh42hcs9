class Solution {
    public List<Character> topSort(HashMap<Character,ArrayList<Character>> graph,HashMap<Character,Integer> inDegree){
        List<Character> topOrder=new ArrayList<>();
        Queue<Character> q=new LinkedList<>();
        for(char c:inDegree.keySet()){
            if(inDegree.get(c)==0) q.offer(c);
        }
        while(!q.isEmpty()){
            char curr=q.poll();
            topOrder.add(curr);
            for(char nei:graph.get(curr)){
                inDegree.put(nei,inDegree.get(nei)-1);
                if(inDegree.get(nei)==0)q.offer(nei);
            }
        }
        return topOrder;
    }
    public HashMap<Character,ArrayList<Character>> createGraph(HashSet<Character> set, List<char[]> edges, HashMap<Character,Integer> inDegree){
        HashMap<Character,ArrayList<Character>> adjList=new HashMap<>();
        for(char c:set){
            adjList.put(c,new ArrayList<>());
            inDegree.put(c,0);
        }
        for(char[] e:edges){
            char u=e[0];
            char v=e[1];
            adjList.get(u).add(v);
            inDegree.put(v,inDegree.get(v)+1);
        }
        
        return adjList;
    }
    public String foreignDictionary(String[] words) {
        List<char[]> edges=new ArrayList<>();
        HashSet<Character> nodes=new HashSet<>();
        for(String w:words){
            for(char c:w.toCharArray()){
                nodes.add(c);
            }
        }
        for(int i=0;i<words.length-1;i++){
            String w1=words[i];
            String w2=words[i+1];
            int len=Math.min(w1.length(), w2.length());
            boolean found=false;
            for(int j=0;j<len;j++){
                if(w1.charAt(j)!=w2.charAt(j)){
                    found=true;
                    edges.add(new char[]{w1.charAt(j),w2.charAt(j)});
                    break;
                }
            }
            if(!found && w1.length()>w2.length()) return "";
        }
        HashMap<Character,Integer> inDegree=new HashMap<>();
        HashMap<Character,ArrayList<Character>> graph=createGraph(nodes,edges,inDegree);
        List<Character> topologicalOrder=topSort(graph,inDegree);
        StringBuilder res=new StringBuilder();
        if(topologicalOrder.size()<nodes.size()) return "";
        for(char c:topologicalOrder){
            res.append(c);
        }
        return res.toString();
    }
}
