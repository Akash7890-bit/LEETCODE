class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer,Integer>DP=new HashMap<>();
        DP.put(0,1);
        for(int num:nums){
            HashMap<Integer,Integer>nextDp=new HashMap<>();
            for(int sum:DP.keySet()){
                int count=DP.get(sum);
                nextDp.put(sum+num,nextDp.getOrDefault(sum+num,0)+count);
                nextDp.put(sum-num,nextDp.getOrDefault(sum-num,0)+count);

            }
            DP=nextDp;
        }
        return DP.getOrDefault(target,0);
    }
}