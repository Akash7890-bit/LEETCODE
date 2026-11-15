class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int evenCount=1;
        int oddCount=0;
        int pSum=0;
        int count=0;
        int mod=1000000007;
        for(int i:arr){
            pSum+=i;
            if(pSum%2==0){
                count=(count+oddCount)%mod;
                evenCount++;
            }
            else{
                count=(count+evenCount)%mod;
                oddCount++;
            }
        }
        return count;
    }
}