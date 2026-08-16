class Solution {
    public ArrayList<ArrayList<Integer>> createGraph(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adjList.get(v).add(u);
        }
        return adjList;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> graph, int curr, HashSet<Integer> vis, HashSet<Integer> path, List<Integer> order){
        vis.add(curr);
        path.add(curr);
        for(int prev:graph.get(curr)){
            if(!vis.contains(prev)){
                if(!dfs(graph,prev,vis,path,order)) return false;
            }
            else if(path.contains(prev)) return false; 
        }
        path.remove(curr);
        order.add(curr);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=createGraph(numCourses,prerequisites);
        HashSet<Integer> vis=new HashSet<>();
        HashSet<Integer> path=new HashSet<>();
        List<Integer> order=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(!vis.contains(i)){
                if(!dfs(graph,i,vis,path,order)) return new int[0];
            }
        }
        int[] arr=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            arr[i]=order.get(numCourses-1-i);
        }
        return arr;
    }
}
