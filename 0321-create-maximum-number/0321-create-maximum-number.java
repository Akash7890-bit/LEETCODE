class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
       int ans[]=new int[k];
       int start=Math.max(0,k-nums2.length);
       int end=Math.min(nums1.length,k);
       for(int i=start;i<=end;i++){
        int[]a=maxSubsequence(nums1,i);
        int[]b=maxSubsequence(nums2,k-i);
        int []merged=merge(a,b);
        if(greater(merged,ans,0,0)){
            ans=merged;
        }
       }
       return ans; 
    }
    private int[] maxSubsequence(int[] nums, int k) {

        int drop = nums.length - k;
        int[] stack = new int[nums.length];
        int top = 0;

        for (int num : nums) {

            while (top > 0 && drop > 0 && stack[top - 1] < num) {
                top--;
                drop--;
            }

            stack[top++] = num;
        }

        return Arrays.copyOf(stack, k);
    }
         
    
    private int[]merge(int[]a,int[]b){
        int ans[]=new int[a.length+b.length];
        int i=0;
        int j=0;
        int idx=0;
        while(i<a.length&&j<b.length){
            if(greater(a,b,i,j)){
                ans[idx]=a[i];
                idx++;
                i++;
            }
            else{
                ans[idx]=b[j];
                idx++;
                j++;
            }
        }
        while(i<a.length){
            ans[idx]=a[i];
            idx++;
            i++;
        }
        while(j<b.length){
            ans[idx]=b[j];
            idx++;
            j++;
        }
        return ans;
       
       
    }
    private boolean greater(int []a,int []b,int i,int j){
        
        while(i<a.length&&j<b.length&&a[i]==b[j]){
            i++;
            j++;
        }
        if(j==b.length){
            return true;
        }
        if(i==a.length){
            return false;
        }
        
        return a[i]>b[j];
    }
}