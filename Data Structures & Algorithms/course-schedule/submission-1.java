class Solution {
    public ArrayList<ArrayList<Integer>> createGraph(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adjList.get(v).add(u);
        }
        return adjList; 
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int curr, boolean[] recStack){
        if(recStack[curr]) return true;
        if(vis[curr]) return false;
        vis[curr]=true;
        recStack[curr]=true;
        for(int u:graph.get(curr)){
            if(isCycle(graph, vis, u, recStack)) return true;
        }
        recStack[curr]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] vis=new boolean[numCourses];
        boolean[] recStack=new boolean[numCourses];
        ArrayList<ArrayList<Integer>> graph=createGraph(numCourses,prerequisites);
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(isCycle(graph,vis,i,recStack)) return false;
            }
        }
        return true;
    }
}
