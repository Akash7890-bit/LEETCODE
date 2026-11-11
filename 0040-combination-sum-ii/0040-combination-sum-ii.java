class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        HashSet<List<Integer>>vis=new HashSet<>();
        Arrays.sort(candidates);

        helper(candidates,target,ans,temp,0,vis);
        return ans;
    }
    void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp, int start,HashSet<List<Integer>>vis) {
        if (target == 0) {
            List<Integer>res=new ArrayList<>(temp);
            Collections.sort(res);
            if(vis.add(res)){
                ans.add(res);
            }
            
        }
        if (target < 0) {
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>target){
                break;
            }
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            helper(candidates,target-candidates[i],ans,temp,i+1,vis);
            temp.remove(temp.size()-1);
        }
        
        

    }
}