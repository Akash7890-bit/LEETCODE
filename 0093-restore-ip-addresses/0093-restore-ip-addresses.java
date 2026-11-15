class Solution {
    public List<String> restoreIpAddresses(String s) {
      List<String>ans=new ArrayList<>();
      int parts=0;
      StringBuilder sb=new StringBuilder("");
      int n=s.length();  
     
      helper(s,n,parts,sb,ans,0);
      return ans;
    }
    void helper(String s,int n,int parts,StringBuilder sb,List<String>ans,int idx){
        if(idx==n && parts==4){
            String res=sb.substring(0,sb.length()-1);
            ans.add(res);
            return;

        }
        int len=sb.length();
        if(idx+1<=n){
            sb.append(s.substring(idx,idx+1)).append(".");
            helper(s,n,parts+1,sb,ans,idx+1);
            sb.setLength(len);

        }
        if(idx+2<=n && isValid(s.substring(idx,idx+2))){
            sb.append(s.substring(idx,idx+2)).append(".");
            helper(s,n,parts+1,sb,ans,idx+2);
            sb.setLength(len);
        }
        if(idx+3<=n && isValid(s.substring(idx,idx+3))){
           sb.append(s.substring(idx,idx+3)).append(".");
            helper(s,n,parts+1,sb,ans,idx+3);
            sb.setLength(len);
        }

    }
    boolean isValid(String s){
        if(s.charAt(0)=='0'){
            return false;
        }
        int n=Integer.parseInt(s);
        return n<=255;
        
    }
}