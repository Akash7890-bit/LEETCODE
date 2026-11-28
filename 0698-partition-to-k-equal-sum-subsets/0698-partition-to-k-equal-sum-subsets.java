class Solution {
    int count=0;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int n=nums.length;
       int totalSum=0;
       for(int i:nums){
        totalSum+=i;
       }
       if(totalSum%k!=0){
        return false;
       }
       int reqSum=totalSum/k;
       boolean visited[]=new boolean[n];
       return helper(0,nums,k,reqSum,0,visited,0);
    }
    boolean helper(int idx,int[] nums, int k,int reqSum,int bucketNum,boolean []visited,int sum){
        if(bucketNum==k){
            return true;
        }
        
        if(sum>reqSum){
            return false;
        }
        if(sum==reqSum){
            return helper(0,nums,k,reqSum,bucketNum+1,visited,0);
        }
        if(idx==nums.length){
            return false;
        }

        int n=nums.length;
        for(int i=idx;i<n;i++){
            if(!visited[i]){
                sum+=nums[i];
                visited[i]=true;
                if(helper(i+1,nums,k,reqSum,bucketNum,visited,sum)){
                    return true;
                }
                sum-=nums[i];
                visited[i]=false;

            }

        }  
        return false;  
    }
    
}