class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;
        int count=1;
        
        for(int right=1;right<nums.length;right++){
            if(nums[left]!=nums[right]){
                nums[left+1]=nums[right];
                left++;
                count++;
            }
        }
        return count; 
        
    }
}