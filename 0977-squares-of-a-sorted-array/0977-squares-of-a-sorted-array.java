class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        int ans[]=new int[n];
        int idx=n-1;
        while(l<=r){
            int leftSq=nums[l]*nums[l];
            int rightSq=nums[r]*nums[r];
            if(leftSq>rightSq){
                ans[idx--]=leftSq;
                l++;
            }
            else{
                ans[idx--]=rightSq;
                r--;
            }

        }
        return ans;

    }
}