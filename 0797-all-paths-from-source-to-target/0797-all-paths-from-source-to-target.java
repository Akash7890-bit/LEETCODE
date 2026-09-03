class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>path=new ArrayList<>();
        path.add(0);
        dfs(0,graph,path,ans);
        return ans;
        
    }
    void dfs(int curr,int[][]graph,List<Integer>path,List<List<Integer>>ans){
        if(curr==graph.length-1){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<graph[curr].length;i++){
            path.add(graph[curr][i]);
            dfs(graph[curr][i],graph,path,ans);
            path.remove(path.size()-1);
        }
    }
}