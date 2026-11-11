class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        
        getPerms(nums,0,ans);
        return ans;
    }
    void getPerms(int[] nums,int idx,List<List<Integer>>ans){
        if(idx==nums.length){
            List<Integer>temp=new ArrayList<>();
            for(int i:nums){
                temp.add(i);
            }
            ans.add(temp);
        }
        for(int i=idx;i<nums.length;i++){
            swap(i,idx,nums);
            getPerms(nums,idx+1,ans);
            swap(idx,i,nums);
        }
    }
    void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}