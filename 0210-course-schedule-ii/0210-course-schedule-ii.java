class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
    boolean vis[]=new boolean[numCourses];
     boolean rec[]=new boolean[numCourses];
     List<Integer> graph[]=new ArrayList[numCourses];
     int ans[]=new int[numCourses];
     for(int i=0;i<numCourses;i++){
        graph[i]=new ArrayList<>();
     }
    for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            graph[u].add(v);
        }
     for(int i=0;i<numCourses;i++){
        if(!vis[i]){
            if(isCycleDFS(prerequisites,numCourses,i,vis,rec,graph)){
                return new int[0];
            }
        }
     }
     Stack<Integer>stack=new Stack<>();
     for(int i=0;i<vis.length;i++){
        vis[i]=false;
     }
     for(int j=0;j<numCourses;j++){
        if(!vis[j]){
            TopSort(prerequisites,numCourses,j,vis,graph,stack);
        }
     }
     int idx=0;
    while(!stack.isEmpty()){
        ans[idx]=stack.pop();
        idx++;
    }
    return ans;

    }
    boolean isCycleDFS(int[][] prerequisites,int numCourses,int src,boolean[]vis,boolean rec[],List<Integer>graph[]){
        vis[src]=true;
        rec[src]=true;
        for(int i=0;i<graph[src].size();i++){
            int v=graph[src].get(i);
        
            
                if(!vis[v]){
                    if(isCycleDFS(prerequisites,numCourses,v,vis,rec,graph)){
                        return true;
                    }
                }
                else if(rec[v]==true){
                    return true;
                }
        }
            
        
        rec[src]=false;
        return false;
    }
    void TopSort(int[][] prerequisites,int numCourses,int src,boolean[]vis,List<Integer>graph[],Stack<Integer>stack){
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            int v=graph[src].get(i);
            if(!vis[v]){
                TopSort(prerequisites,numCourses,v,vis,graph,stack);
            }
        }
        stack.push(src);

    }
}