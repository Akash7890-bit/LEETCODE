class Solution {
    int time=0;
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
       
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            vis[i]=false;
        }
        int dt[]=new int[n];
        int low[]=new int[n];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++){
            int u=connections.get(i).get(0);
            int v=connections.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
       for(int i=0;i<n;i++){
        if(!vis[i]){
             dfs(graph,vis,dt,low,i,-1);
        }
       }
       return ans;

    }

    void dfs(List<List<Integer>> graph,boolean vis[],int dt[],int low[],int curr,int par){
        vis[curr]=true;
        dt[curr]=low[curr]=time++;
        for(int i=0;i<graph.get(curr).size();i++){
            int edge=graph.get(curr).get(i);
            if(edge==par){
                continue;
            }
            if(!vis[edge]){
                dfs(graph,vis,dt,low,edge,curr);
                low[curr]=Math.min(low[curr],low[edge]);
                if(dt[curr]<low[edge]){
                    ans.add(Arrays.asList(curr,edge));
                }
            }else{
                low[curr]=Math.min(dt[edge],low[curr]);
            }

        }
    }

}