class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res=0;
        int len=endWord.length();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        while(!q.isEmpty()){
            res++;
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                for(int j=0;j<len;j++){
                    char ch=curr.charAt(j);
                    char[] word=curr.toCharArray();
                    for(char c='a';c<='z';c++){
                        word[j]=c;
                        String newWord=new String(word);
                        if(!set.contains(newWord)) continue;
                        if(newWord.equals(endWord)) return res+1;
                        set.remove(newWord);
                        q.offer(newWord); 
                    }
                    word[j]=ch;
                }
            }
        }
        return 0;
    }
}
