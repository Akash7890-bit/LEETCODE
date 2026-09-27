class Solution {
    public int longestConsecutive(int[] nums) {
        int ans=0;
        HashMap<Integer,Boolean>map=new HashMap<>();
        for(int n:nums){
            map.put(n,Boolean.FALSE);
        }
        for(int num:nums){
            int longestLength=1;
            int nextNum=num+1;
            while(map.containsKey(nextNum) && map.get(nextNum)==false){
                longestLength++;
                map.put(nextNum,Boolean.TRUE);
                nextNum++;
            }
            int prevNum=num-1;
             while(map.containsKey(prevNum) && map.get(prevNum)==false){
                longestLength++;
                map.put(prevNum,Boolean.TRUE);
                prevNum--;
            }
            ans=Math.max(ans,longestLength);

        }
        return ans;
    }
}