class Solution {
    public boolean isAnagram(String s, String t) {
       int arr1[]=new int[26];
       int arr2[]=new int[26];
       for(char c:s.toCharArray()){
        arr1[c-'a']++;
       }
        for(char c:t.toCharArray()){
        arr2[c-'a']++;
       }
       return Arrays.equals(arr1,arr2);

    }
}