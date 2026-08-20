class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<Integer> stack=new Stack<>();
        int i=0;
        while(i<n){
            String curr=tokens[i];
            if(curr.equals("+")){
                //if(stack.isEmpty() || stack.size()<2) return 0;
                int first=stack.pop();
                int second=stack.pop();
                int res=first+second;
                stack.push(res);
            }
            else if(curr.equals("-")){
                //if(stack.isEmpty()||stack.size()<2) return 0;
                int first=stack.pop();
                int second=stack.pop();
                int res=second-first;
                stack.push(res);
            }
            else if(curr.equals("*")){
                //if(stack.isEmpty()||stack.size()<2) return 0;
                int first=stack.pop();
                int second=stack.pop();
                int res=first*second;
                stack.push(res);
            }
            else if(curr.equals("/")){
                //if(stack.isEmpty()||stack.size()<2) return 0;
                int first=stack.pop();
                int second=stack.pop();
                //if(second==0) return 0;
                int res=second/first;
                stack.push(res);
            }
            else{
                int num=Integer.parseInt(curr);
                stack.push(num);
            }
            i++;
        }
        return stack.peek();
    }
}
