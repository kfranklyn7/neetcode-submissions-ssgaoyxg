class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //we want to group each anagram agnostic of their order of characters
        //sorting each string gives us characters in the same order
        Map<String,ArrayList<String>> groups = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String word: strs){
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String anagram = new String(letters);
            groups.put(anagram,groups.getOrDefault(anagram,new ArrayList<String>()));
            groups.get(anagram).add(word);
        }
        for (List<String> anagrams : groups.values()){
            result.add(anagrams);
        }


        return result;

    }
}
