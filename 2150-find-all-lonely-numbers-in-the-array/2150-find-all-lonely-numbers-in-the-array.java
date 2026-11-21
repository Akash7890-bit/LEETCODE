class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        List<Integer>ans=new ArrayList<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);

        }
        for(int i:nums){
            if(map.get(i)==1){
                if(map.get(i+1)==null && map.get(i-1)==null){
                    ans.add(i);
                }
            }
        }
        return ans;

    }
}