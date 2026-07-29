class Solution {
    public boolean isAnagram(String s, String t) {
        int m=t.length();
        int n=s.length();
        if(n!=m) return false;
        char[] arr1 = new char[n];
       for(int i=0;i<s.length();i++){
            arr1[i] = s.charAt(i);
       }
       HashMap<Character, Integer> map=new HashMap<>();
       for(char c:arr1){
        map.put(c,map.getOrDefault(c,0)+1);
       }
       for(int i=0;i<m;i++){
        char c=t.charAt(i);
        if(!map.containsKey(c)) return false;
        else{
            int count = map.get(c)-1;
            map.put(c,count);
        }
       }
       for(Map.Entry<Character, Integer> e: map.entrySet()){
        if(e.getValue()>0) return false;
       }
       return true; 
    }
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> ans=new ArrayList<>();
       int n=strs.length;
       boolean[] vis=new boolean[n];
       Arrays.fill(vis, false);
       for(int i=0;i<n;i++){
        List<String> l=new ArrayList<>();
            if(vis[i]==false){
                l.add(strs[i]);
                vis[i]=true;
                String curr = strs[i];
                for(int j=i+1;j<n;j++){
                    if(!vis[j] && isAnagram(curr, strs[j])){
                        l.add(strs[j]);
                        vis[j]=true;
                    } 
                }
                ans.add(l);  
            }
            
       }
       return ans;
    }
}
