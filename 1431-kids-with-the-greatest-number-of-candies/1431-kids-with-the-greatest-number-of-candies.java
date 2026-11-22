class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean>ans=new ArrayList<>();
       int maxCandies=0;
       for(int i:candies){
        maxCandies=Math.max(i,maxCandies);

       } 
       for(int i:candies){
        if(i+extraCandies>=maxCandies){
            ans.add(true);
        }
        else{
            ans.add(false);
        }
       }
       return ans;
    }
}