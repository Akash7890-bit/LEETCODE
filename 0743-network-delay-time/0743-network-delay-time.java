class pair{
    int node;
    int tm;
    public pair(int node,int tm){
        this.node=node;
        this.tm=tm;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int []time=new int[n+1];
        int ans=-1;
        ArrayList<pair>graph[]=new ArrayList[n+1];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int []edge:times){
            graph[edge[0]].add(new pair(edge[1],edge[2]));
        }
        
      Arrays.fill(time,Integer.MAX_VALUE);
       time[k]=0; 

       PriorityQueue<pair>qu=new PriorityQueue<>((a,b)->a.tm-b.tm);
       qu.offer(new pair(k,time[k]));
       while(!qu.isEmpty()){
        pair curr=qu.poll();
        int u=curr.node;
        int tm=curr.tm;
        
        for(int i=0;i<graph[u].size();i++){
            int v=graph[u].get(i).node;
            int vTime=graph[u].get(i).tm;
            if(tm+vTime<time[v]){
                time[v]=tm+vTime;
                qu.offer(new pair(v,time[v]));

            }
            
            
        }

       }
       for(int i=1;i<=n;i++){
        if(time[i]==Integer.MAX_VALUE){
            return -1;
        }
        ans=Math.max(ans,time[i]);
       }
       return ans;


    }
}
