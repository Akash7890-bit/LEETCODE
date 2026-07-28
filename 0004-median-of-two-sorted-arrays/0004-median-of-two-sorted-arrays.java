class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int n=nums1.length;
      int m=nums2.length;
      int total=m+n;
      int i=0;
      int j=0;
      int prev=0;
      int curr=0;
      for(int c=0;c<=total/2;c++){
        prev=curr;
        if(i<n && j<m){
            if(nums1[i]<nums2[j]){
            curr=nums1[i++];

            }
            else {
            curr=nums2[j++];
            }
        
        }
        else if(i<n){
            curr=nums1[i++];
        }
        else{
            curr=nums2[j++];
        }
      }

    if(total%2==1){
        return curr;
    }      
    else{
        return (prev+curr)/2.0;
    }  
    
    }
}