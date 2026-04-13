class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //How do we know something is an anagram?
        //An anagram would contain the same number of letters
        //We can group strings based on whether they have the same characters or not
        Map<String,List<String>> groups = new HashMap<>();
        for(String word : strs){
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            groups.put(key,groups.getOrDefault(key,new ArrayList<String>()));
            groups.get(key).add(word);
        }
        return new ArrayList<>(groups.values());
    }
}
