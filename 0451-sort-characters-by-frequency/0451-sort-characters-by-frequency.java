class pair{
    char word;
    int freq;
    pair(char word,int freq){
        this.word=word;
        this.freq=freq;
    }
}
class Solution {
    public String frequencySort(String s) {
       HashMap<Character,Integer>fMap=new HashMap<>();
       for(char c:s.toCharArray()){
            fMap.put(c,fMap.getOrDefault(c,0)+1);
       }
       PriorityQueue<pair>qu=new PriorityQueue<>((a,b)->b.freq-a.freq);
       for(char key:fMap.keySet()){
        qu.offer(new pair(key,fMap.get(key)));
       }
       
    StringBuilder sb=new StringBuilder();
       while(!qu.isEmpty()){
        char curr=qu.poll().word;
        for(int i=0;i<fMap.get(curr);i++){
            sb.append(curr);
        }
       }
       return sb.toString();
       
       
           
       
           


    }
}