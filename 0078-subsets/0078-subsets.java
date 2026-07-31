class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>resultList=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
         BT(resultList,temp,nums,0);
         return resultList;
    }
    private void BT( List<List<Integer>>result,List<Integer>temp,int[]nums,int start){
        result.add(new ArrayList<>(temp));

        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            BT(result,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
        
    }
}