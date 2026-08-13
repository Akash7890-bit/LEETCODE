class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int candidate=nums[0];
        int c=1;
        for(int i=1;i<n;i++){
            if(candidate==nums[i]){
                c++;
            }
            else{
                c--;
            }
            if(c==0){
                candidate=nums[i];
                c=1;
            }
        }
        return candidate;
    }
}