class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> vis = new HashSet<>();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        subsets(ans,temp,nums,0,vis);
        return ans;

    }

    private void subsets(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start,HashSet<List<Integer>> vis) {
        List<Integer>res=new ArrayList<>(temp);
        Collections.sort(res);

        
           if(vis.add(res)){
             ans.add(res);
           }
        
        
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            subsets(ans, temp, nums, i + 1,vis);
            temp.remove(temp.size()-1);
        }
        
    }
}