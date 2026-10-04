class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    HashMap<String,List<String>>graph=new HashMap<>();
    HashMap<String,Integer>indegree=new HashMap<>();
    for(int i=0;i<recipes.length;i++){
        for(int j=0;j<ingredients.get(i).size();j++){
            graph.putIfAbsent(ingredients.get(i).get(j),new ArrayList<>());
            graph.get(ingredients.get(i).get(j)).add(recipes[i]);
        }
        indegree.put(recipes[i],ingredients.get(i).size());
       
        }    
     Queue<String>qu=new LinkedList<>();
        for(int i=0;i<supplies.length;i++){
            qu.offer(supplies[i]);
        } 
        List<String>ans=new ArrayList<>();
        while(!qu.isEmpty()){

            String supply=qu.poll();
            for(String recipe:graph.getOrDefault(supply,new ArrayList<>())){
                indegree.put(recipe,indegree.get(recipe)-1);
                if(indegree.get(recipe)==0){
                    ans.add(recipe);
                    qu.offer(recipe);
                }
                
            }
        }
        return ans; 
    } 
    


}