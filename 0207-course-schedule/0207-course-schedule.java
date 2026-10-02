class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     boolean vis[]=new boolean[numCourses];
     boolean rec[]=new boolean[numCourses];
     for(int i=0;i<numCourses;i++){
        if(!vis[i]){
            if(isCycleDFS(prerequisites,numCourses,i,vis,rec)){
                return false;
            }
        }
     }
     return true;

    }
    boolean isCycleDFS(int[][] prerequisites,int numCourses,int src,boolean[]vis,boolean rec[]){
        vis[src]=true;
        rec[src]=true;
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            if(src==u){
                if(!vis[v]){
                    if(isCycleDFS(prerequisites,numCourses,v,vis,rec)){
                        return true;
                    }
                }
                else if(rec[v]==true){
                    return true;
                }
            }
        }
        rec[src]=false;
        return false;
    }
}