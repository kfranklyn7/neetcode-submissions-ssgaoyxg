class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //we can group strings that are anagrams by sorting them individually in alphabetical order
        //we can use a hashmap to store a list of these groups of strings using their sorted form as the key
        Map<String,ArrayList<String>> groups = new HashMap<>();

        //We will iterate over each index to retrieve each string
        for (int index = 0; index < strs.length; index++){
        char[] letters = strs[index].toCharArray();
        //We'll use this sorted form of letters as the key of our map
        Arrays.sort(letters);
        String anagram = new String(letters);
        
        //if we do not have any value for this key, we make a new ArrayList
                groups.put(anagram,groups.getOrDefault(anagram,new ArrayList<>()));
                groups.get(anagram).add(strs[index]);
        
        //We now place the string at this index in with its respective key
 
        }
        List<List<String>> result = new ArrayList();
        for (List<String> anagrams : groups.values()){
            result.add(anagrams);
        }
        return result;
        
    }
}
