class Solution {
    public int search(int[] nums, int target) {
         return findMid(nums,target,0,nums.length-1);
        
       
    
    }
     int findMid(int []nums,int target,int l,int r){
        if(l>r){
            return -1;
        }
        int mid=l+(r-l)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]>target){
           return findMid(nums,target,l,mid-1);
        }
        
        return findMid(nums,target,mid+1,r);
    

    }
}