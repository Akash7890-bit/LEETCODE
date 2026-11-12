class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        HashSet<List<Integer>>vis=new HashSet<>();
        getPerms(nums,ans,0,vis);
        return ans;

    }
    void getPerms(int []nums,List<List<Integer>>ans,int idx,HashSet<List<Integer>>vis){
        if(idx==nums.length){
            List<Integer>temp=new ArrayList<>();
            for(int i:nums){
                temp.add(i);
            }
            
            if(vis.add(temp)){
            ans.add(temp);
            }
        }
        for(int i=idx;i<nums.length;i++){
            swap(i,idx,nums);
            getPerms(nums,ans,idx+1,vis);
            swap(i,idx,nums);
        }
    }
    void swap(int i,int j,int []nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}