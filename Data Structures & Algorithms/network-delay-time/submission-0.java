class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] t:times){
            graph.get(t[0]).add(new int[]{t[1],t[2]});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        boolean[] vis = new boolean[n+1];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int node = curr[1];
            if(vis[node]) continue;
            vis[node] = true;
            for(int[] nei : graph.get(node)){
                int next = nei[0];
                int w = nei[1];
                if(dist[node] + w < dist[next]){
                    dist[next] = dist[node] + w;
                    pq.add(new int[]{dist[next], next});
                }
            }   
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}