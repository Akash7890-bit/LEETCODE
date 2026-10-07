class pair{
    int node;
    int wt;
    pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}
class Solution {
    public int calWeight(int[][] points,int p,int q){
        return Math.abs(points[p][0]-points[q][0])+Math.abs(points[p][1]-points[q][1]);
    }
    public int minCostConnectPoints(int[][] points) {
        
        int n=points.length;
        int ans=0;
        boolean mst[]=new boolean[n];
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)-> a.wt-b.wt);
        pq.offer(new pair(0,0));
        while(!pq.isEmpty()){
            pair curr=pq.poll();
            if(mst[curr.node]==true){
                continue;
            }
            mst[curr.node]=true;
            ans+=curr.wt;
            for(int i=0;i<n;i++){
                if(!mst[i]){
                    int edgeWt=calWeight(points,curr.node,i);
                    pq.offer(new pair(i,edgeWt));
                }
            }


        }
        return ans;
    }
}