class Solution {
    int parent[];
    public int makeConnected(int n, int[][] connections) {
        int ans=n;
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int len=connections.length;
        for(int i=0;i<len;i++){
            int element1=connections[i][0];
            int element2=connections[i][1];
            int rootA=find(element1);
            int rootB=find(element2);
            if(rootA==rootB){
                continue;
            }
            union(element1,element2);
            ans--;
        }
        if(len<n-1){
            return -1;
        }
        return ans-1;

    }
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    void union(int a,int b){
        int root1=find(a);
        int root2=find(b);
        if(root1==root2){
            return;
        }
        parent[root2]=root1;
        
    }
}