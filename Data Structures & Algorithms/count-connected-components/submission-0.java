class Solution {
    public ArrayList<ArrayList<Integer>> createGraph(int n, int[][] edges){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        } 
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
    public void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis,int i){
        vis[i]=true;
        for(int nei:graph.get(i)){
            if(!vis[nei]){
                vis[nei] = true;
                dfs(graph,vis,nei);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = createGraph(n, edges);
        int count=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(graph,vis,i);
            }
        }
        return count;
    }
}
