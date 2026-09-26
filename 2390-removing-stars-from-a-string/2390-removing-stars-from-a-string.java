class Solution {
    public String removeStars(String s) {
        StringBuilder sb=new StringBuilder();
        
        for(char str:s.toCharArray()){
            if( str=='*'){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                 sb.append(str);
            }
           
        }
        
        
        return sb.toString();
    }
}