class Solution {
    public String removeStars(String s) {
        Stack<Character>stack=new Stack<>();
        for(char str:s.toCharArray()){
            if(!stack.isEmpty() && str=='*'){
                stack.pop();
            }
            else{
                 stack.push(str);
            }
           
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}