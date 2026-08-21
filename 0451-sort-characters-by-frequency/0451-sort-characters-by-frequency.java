class Solution {
    public String frequencySort(String s) {
       HashMap<Character,Integer>fMap=new HashMap<>();
       for(char c:s.toCharArray()){
            fMap.put(c,fMap.getOrDefault(c,0)+1);
       }
       int size=s.length();
        ArrayList<Character>freq[]=new ArrayList[size+1];
       for(char key:fMap.keySet()){
            int f=fMap.get(key);
            if(freq[f]==null){
                freq[f]=new ArrayList<>();
            }
            freq[f].add(key);
       }
        StringBuilder sb=new StringBuilder();
       
       for(int i=freq.length-1;i>=0;i--){
        if(freq[i]!=null){
           for(int j=0;j<freq[i].size();j++){
            char ch=freq[i].get(j);
            for(int k=0;k<i;k++){
                sb.append(ch);
            }
           }
        }
       }
       return sb.toString();
           
       
           


    }
}