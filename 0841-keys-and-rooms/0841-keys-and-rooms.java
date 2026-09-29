class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
       boolean vis[]=new boolean[n];
       for(int i=0;i<n;i++){
        vis[i]=false;
       } 
       dfs(rooms,vis,0);
       for(int j=0;j<rooms.size();j++){
        if(!vis[j]){
            return false;
        }
       }
       return true;
    }
    void dfs(List<List<Integer>> rooms,boolean[]vis,int curr){
        vis[curr]=true;
        for(int i=0;i<rooms.get(curr).size();i++){
            int edge=rooms.get(curr).get(i);
            if(!vis[edge]){
                dfs(rooms,vis,edge);
            }
        }
    }
}