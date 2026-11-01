class pair{
    String word;
    int freq;
    public pair(String word,int freq){
        this.word=word;
        this.freq=freq;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        
        PriorityQueue<pair>qu=new PriorityQueue<>((a,b)->{
            if(a.freq!=b.freq){
                return b.freq-a.freq;
            }
            return a.word.compareTo(b.word);
        });
        HashMap<String,Integer>map=new HashMap<>();
         
        
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
            
        }
        for(String key:map.keySet()){
            
            qu.offer(new pair(key,map.get(key)));
            
        }
        List<String>result=new ArrayList<>();
        for(int i=1;i<=k;i++){
            result.add(qu.poll().word);
        }
        return result;
    }
}