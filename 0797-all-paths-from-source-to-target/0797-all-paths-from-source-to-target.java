class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>path=new ArrayList<>();
  
        dfs(0,graph,path,ans);
        return ans;
        
    }
    void dfs(int curr,int[][]graph,List<Integer>path,List<List<Integer>>ans){
          path.add(curr);
        if(curr==graph.length-1){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<graph[curr].length;i++){
        
            dfs(graph[curr][i],graph,path,ans);
            path.remove(path.size()-1);
        }
    }
}