class Solution {
    public String minRemoveToMakeValid(String s) {
       int open =0;
       StringBuilder first=new StringBuilder();
       for(char ch:s.toCharArray()) {
        if(ch=='('){
            open++;
            first.append(ch);
            
        }
        else if(ch==')'){
           if(open>0){
            open--;
            first.append(ch);
           }
           
        }
        else{
            first.append(ch);
        }
       }
       int close=0;
       StringBuilder ans=new StringBuilder();
       for(int i=first.length()-1;i>=0;i--) {
        char ch=first.charAt(i);
        if(ch==')'){
            close++;
            ans.append(ch);
            
        }
        else if(ch=='('){
           if(close>0){
            close--;
            ans.append(ch);
           }
           
        }
        else{
            ans.append(ch);
        }
       }
       return ans.reverse().toString();
    }
}