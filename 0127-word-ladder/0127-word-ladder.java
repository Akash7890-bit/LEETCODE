class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      int n=wordList.size();
      Queue<String>qu=new LinkedList<>();
      int words=1;
      if(!wordList.contains(endWord)){
        return 0;
      }
      
      
      Set<String>WordLis=new HashSet<>();
      for(int i=0;i<n;i++){
        WordLis.add(wordList.get(i));
      }
      qu.offer(beginWord);
      if(WordLis.contains(beginWord)){
        WordLis.remove(beginWord);
      }
      while(!qu.isEmpty()){
        int k=qu.size();
        for(int i=0;i<k;i++){
            String currWord=qu.poll();
            if(currWord.equals(endWord)){
                return words;
            }
            char chars[]=currWord.toCharArray();
            for(int j=0;j<chars.length;j++){
                for(char c='a';c<='z';c++){
                    char original=chars[j];
                    chars[j]=c;
                    String newWord=new String(chars);
                    if(WordLis.contains(newWord)){
                        qu.offer(newWord);
                        WordLis.remove(newWord);
                    }
                    chars[j]=original;
                }
            }
        }
        words++;
      }
        return 0;

    }
}