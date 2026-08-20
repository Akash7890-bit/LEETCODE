class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>fMap=new HashMap<>();
        List<Integer>bucket[]=new List[nums.length+1];
        for(int i=0;i<nums.length;i++){
            fMap.put(nums[i],fMap.getOrDefault(nums[i],0)+1);

        }
        for(int key:fMap.keySet()){
            int freq=fMap.get(key);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
               
            }
             bucket[freq].add(key);
        }
        int ans[]=new int[k];
        int count=0;
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(int j=0;j<bucket[i].size() && count<k;j++){
                    ans[count]=bucket[i].get(j);
                    count++;
                }
            }
        }
        return ans;
    }
}