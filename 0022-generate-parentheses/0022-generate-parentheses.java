class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        
        helper(n,0,0,ans,sb);
        return ans;
        
    }
    void helper(int n,int open,int close,List<String>ans,StringBuilder sb){
        if(sb.length()==2*n){
          ans.add(sb.toString()); 
        }
        if(open<n){
            sb.append("(");
            helper(n,open+1,close,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
         if(close<open){
            sb.append(")");
            helper(n,open,close+1,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}