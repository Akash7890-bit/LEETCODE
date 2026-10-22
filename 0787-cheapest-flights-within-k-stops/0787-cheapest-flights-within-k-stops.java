
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int []edge:flights){
            graph[edge[0]].add(new int[]{edge[1],edge[2]});
        }
        
        
        int []dt=new int[n];
        Arrays.fill(dt,Integer.MAX_VALUE);
        dt[src]=0;
        
       Queue<int[]>qu=new LinkedList<>();

        qu.offer(new int[]{src,dt[src]});
        int stops=0;

        while(!qu.isEmpty() && stops<=k){
            int len=qu.size();
            int []tempDT=Arrays.copyOf(dt,n); 
            for(int i=0;i<len;i++){
                int []curr=qu.poll();
                int u=curr[0];
                int uPrice=curr[1];
                for(int j=0;j<graph[u].size();j++){
                    int v=graph[u].get(j)[0];
                    int vPrice=graph[u].get(j)[1];
                    if(uPrice+vPrice<tempDT[v]){
                        tempDT[v]=uPrice+vPrice;
                        qu.offer(new int[]{v,tempDT[v]});
                        
                    }
                }

            }
            dt=tempDT;
            stops++;



        }
        if(dt[dst]!=Integer.MAX_VALUE){
            return dt[dst];
        }
        else{
            return -1;
        }

    }
}