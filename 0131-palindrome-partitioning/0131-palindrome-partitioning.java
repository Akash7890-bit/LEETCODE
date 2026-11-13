class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>temp=new ArrayList<>();
        gap(s,temp,ans,0);
        return ans;

    }
     private boolean isPal(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private void gap(String s,List<String>temp,List<List<String>>ans,int idx){
        if(idx==s.length()){
            List<String>res=new ArrayList<>();
            for(String i:temp){
                res.add(i);
            }
            ans.add(res);
            return;
        }
        for(int i=idx;i<s.length();i++){
           
            if(isPal(s,idx,i)){
                temp.add(s.substring(idx,i+1));
                gap(s,temp,ans,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}