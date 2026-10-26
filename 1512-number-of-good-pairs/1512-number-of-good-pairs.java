class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int j=0;j<nums.length;j++){
           if(map.containsKey(nums[j])){
                count+=map.get(nums[j]);
                 map.put(nums[j],map.getOrDefault(nums[j],0)+1);
           }
           else{
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
           }

        }
        return count;
    }
}