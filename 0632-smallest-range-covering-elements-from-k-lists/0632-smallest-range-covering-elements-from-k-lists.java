class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
       PriorityQueue<int []>pq=new PriorityQueue<>(new Comparator<int []>(){
        public int compare(int []a,int []b){
            return a[0]-b[0];
        }
       });
       int n=nums.size();
       int max=Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
        int minValue=nums.get(i).get(0);
        pq.offer(new int[]{minValue,i,0});
        max=Math.max(max,minValue);
       } 
       int minRange[]={0,Integer.MAX_VALUE};
       while(true){
        int []curr=pq.poll();
        int minElement=curr[0];
        int listIdx=curr[1];
        int elementIdx=curr[2];
        if(max-minElement<(minRange[1]-minRange[0])){
            minRange[0]=minElement;
            minRange[1]=max;
        }
        if(elementIdx==nums.get(listIdx).size()-1){
            break;
        }
        int next=nums.get(listIdx).get(elementIdx+1);
        max=Math.max(max,next);
        pq.offer(new int[]{next,listIdx,elementIdx+1});
       }
       return minRange;

    }
}