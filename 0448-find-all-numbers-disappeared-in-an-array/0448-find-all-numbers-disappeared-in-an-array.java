class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
       List<Integer>ans=new ArrayList<>();
       HashSet<Integer>vis=new HashSet<>();
       for(int i=0;i<n;i++){
            if(vis.add(Math.abs(nums[i]))){
            int idx=Math.abs(nums[i])-1;
            nums[idx]=-nums[idx];
            }
        }
       for(int i=0;i<n;i++){
        if(nums[i]>0){
            ans.add(i+1);
            
        }
       }
       return ans; 
    }
}