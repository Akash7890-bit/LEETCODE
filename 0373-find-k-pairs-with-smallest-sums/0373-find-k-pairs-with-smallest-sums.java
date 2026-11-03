class pair{
    int index[];
    int sum;
    pair(int index[],int sum){
        this.index=index;
        this.sum=sum;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)-> a.sum-b.sum);
        int m=nums1.length;
        int n=nums2.length;
        int i=0;
        int j=0;
        HashSet<String>visited=new HashSet<>();
        pq.offer(new pair(new int[]{i,j},(nums1[i]+nums2[j])));
        visited.add("0,0");
        
        List<List<Integer>>ans=new ArrayList<>();
        while(k>0 && !pq.isEmpty()){
            pair curr=pq.poll();
            int idx1=curr.index[0];
            int idx2=curr.index[1];
            int sum=curr.sum;
            
            List<Integer>temp=new ArrayList<>();
            temp.add(nums1[idx1]);
            temp.add(nums2[idx2]);
            ans.add(temp);
            k--;
            String key1=(idx1)+","+(idx2+1);
            if(idx1<m && idx2+1<n  && !visited.contains(key1)){
                pq.offer(new pair(new int[]{idx1,idx2+1},(nums1[idx1]+nums2[idx2+1])));
                visited.add(key1);
            }
            String key2=(idx1+1)+","+(idx2);
            if(idx1+1<m && idx2<n  && !visited.contains(key2)){
                pq.offer(new pair(new int[]{idx1+1,idx2},(nums1[idx1+1]+nums2[idx2])));
                visited.add(key2);
                }
        }
        return ans;
    }
}