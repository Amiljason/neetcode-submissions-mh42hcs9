class Twitter {
    PriorityQueue<int[]> post;
    PriorityQueue<int[]> temp;
    HashMap<Integer,HashSet<Integer>> map;
    public int time=0;
    public Twitter() {
        post=new PriorityQueue<>((a,b)->Integer.compare(b[2],a[2]));
        temp=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        map=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)){
            map.put(userId,new HashSet<>());
            post.offer(new int[]{userId,tweetId,time++});
        }
        else{
            post.offer(new int[]{userId,tweetId,time++});
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        int count=10;
        List<Integer> feed=new ArrayList<>();
        while(!post.isEmpty() && count!=0){
            int[] curr=post.poll();
            if(curr[0]==userId || map.get(userId).contains(curr[0])){
                feed.add(curr[1]);
                count--;
                temp.add(curr);
            }
            else temp.add(curr);
        }
        while(!temp.isEmpty()){
            int[] prev=temp.poll();
            post.offer(prev);
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!map.containsKey(followerId)){
            map.put(followerId,new HashSet<>());
            map.get(followerId).add(followeeId);
        }
        else{
            map.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        map.get(followerId).remove(followeeId);
    }
}
