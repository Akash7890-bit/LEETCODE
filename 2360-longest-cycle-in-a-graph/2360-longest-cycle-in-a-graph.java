class Solution {
    int result=-1;
    public int longestCycle(int[] edges) {
        int n=edges.length;
        
        boolean []vis=new boolean[n];
        boolean []rec=new boolean[n];
        int count[]=new int[n];

        for(int i=0;i<n;i++){
            vis[i]=false;
            rec[i]=false;
        }
         for(int i=0;i<n;i++){
           count[i]=1;
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(edges,vis,rec,count,i);
            }
        }
        
        return result;
    }
    void dfs(int []edges,boolean []vis,boolean []rec,int []count,int curr){
        if(curr==-1){
            return;
        }
        vis[curr]=true;
        rec[curr]=true;
        int e=edges[curr];
        if(e!=-1 && vis[e]==true && rec[e]==true ){
            result=Math.max(result,count[curr]-count[e]+1);
        }
        else if(e!=-1 && vis[e]!=true){
            count[e]=count[curr]+1;
           dfs(edges,vis,rec,count,e);
           
        }
        rec[curr]=false;
    }
    

}