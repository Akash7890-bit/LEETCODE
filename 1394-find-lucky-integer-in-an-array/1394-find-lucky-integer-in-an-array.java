class Solution {
    public int findLucky(int[] arr) {
        int maxAns=-1;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int key:map.keySet()){
            if(key==map.get(key)){
                maxAns=Math.max(maxAns,key);
            }
        }
        return maxAns;
    }
}