class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>temp=new ArrayList<>();
        gap(s,temp,ans);
        return ans;

    }
    private boolean isPal(String s){
        StringBuilder sb=new StringBuilder(s);
        String s2=sb.reverse().toString();
        
        return s.equals(s2);
    }
    private void gap(String s,List<String>temp,List<List<String>>ans){
        if(s.length()==0){
            List<String>res=new ArrayList<>();
            for(String i:temp){
                res.add(i);
            }
            ans.add(res);
            return;
        }
        for(int i=0;i<s.length();i++){
            String part=s.substring(0,i+1);
            if(isPal(part)){
                temp.add(part);
                gap(s.substring(i+1),temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }
}