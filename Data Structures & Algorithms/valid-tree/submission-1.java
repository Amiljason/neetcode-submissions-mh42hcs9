class Solution {
    public ArrayList<ArrayList<Integer>> createGraph(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int node, int parent){
        vis[node]=true;
        for(int nei:graph.get(node)){
            if(vis[nei] && nei!=parent) return true; 
            if(!vis[nei]){
                if(isCycle(graph,vis,nei,node)) return true;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph=createGraph(n,edges);
        boolean[] vis=new boolean[n];
        if(isCycle(graph,vis,0,0)) return false;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
}
