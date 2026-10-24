class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int breakPoint=-1;
        int lessbreakPoint=0;
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                breakPoint=i-1;
                break;

            }
        }
        if(breakPoint!=-1){
            for(int j=n-1;j>breakPoint;j--){
            if(nums[j]>nums[breakPoint]){
                lessbreakPoint=j;
                break;
                
            }
        }
        int temp=nums[breakPoint];
        nums[breakPoint]=nums[lessbreakPoint];
        nums[lessbreakPoint]=temp;
         reverse(nums,breakPoint+1,n-1);
        }
        else{
            reverse(nums,breakPoint+1,n-1);
        }
       
        
    }
    void reverse(int[] nums,int l,int r){
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}