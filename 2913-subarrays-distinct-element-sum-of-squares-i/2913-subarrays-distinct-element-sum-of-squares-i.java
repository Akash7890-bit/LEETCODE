class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int ans=0;
        for(int i=0;i<n;i++){
            boolean seen[]=new boolean[101];
            int dist=0;
            for(int j=i;j<n;j++){
                int x=nums.get(j);
                if(!seen[x]){
                    seen[x]=true;
                    dist++;
                }
                ans+=dist*dist;
            }
        }
        return ans;
    }
}