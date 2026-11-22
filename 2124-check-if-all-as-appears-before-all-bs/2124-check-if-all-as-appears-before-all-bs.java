class Solution {
    public boolean checkString(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='b' && i==0){
            continue;
            
           }
           if(s.charAt(i)=='a' && i==0){
            continue;
            

           }
           if(s.charAt(i)=='a' && s.charAt(i-1)=='b'){
            return false;
            

           }
        }
        return true;
    }
}