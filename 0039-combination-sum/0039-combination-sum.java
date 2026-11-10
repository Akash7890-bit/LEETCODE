class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        HashSet<List<Integer>>vis=new HashSet<>();

        helper(candidates,target,ans,temp,0,vis);
        return ans;

    }

    void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp, int idx,HashSet<List<Integer>>vis) {
        if (idx == candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer>res=new ArrayList<>(temp);
            Collections.sort(res);
            if(vis.add(res)){
                ans.add(res);
            }
            
        }
        temp.add(candidates[idx]);

        helper(candidates, target - candidates[idx], ans, temp, idx + 1,vis);
        helper(candidates, target - candidates[idx], ans, temp, idx,vis);
        temp.remove(temp.size() - 1);
        helper(candidates, target, ans, temp, idx + 1,vis);

    }
}