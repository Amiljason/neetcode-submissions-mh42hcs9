class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        int i=0;
        while(i<n){
            if(s.charAt(i)=='['||s.charAt(i)=='('||s.charAt(i)=='{') stack.push(s.charAt(i));
            else if(stack.size()==0||s.charAt(i)==']' && stack.peek()!='[') return false;
            else if(stack.size()==0||s.charAt(i)==')' && stack.peek()!='(') return false;
            else if(stack.size()==0||s.charAt(i)=='}' && stack.peek()!='{') return false;
            else stack.pop();
            i++;
        }
        return (stack.size()==0)?true:false;
    }
}
