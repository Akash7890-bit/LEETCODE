class Solution {
    public String removeOuterParentheses(String s) {
        int balance=0;
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                balance++;
                if(balance>1){
                    sb.append(ch);
                }
            }
            else{
                balance--;
                if(balance>0){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}