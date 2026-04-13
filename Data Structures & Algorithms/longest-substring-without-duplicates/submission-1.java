class Solution {
    public int lengthOfLongestSubstring(String s) {
        //I know this is a sliding window problem
        // for any given interval we can check if a character has appeared before using a HashSet
        // if we encounter a character we've already seen, we increment the left pointer and remove the character
        // thought we could simply return the size of the hashset
        // instead we can return the difference in indexes + 1
        Set<Character> seen = new HashSet<>();
        int leftPointer = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            while (seen.contains(s.charAt(i))){
                seen.remove(s.charAt(leftPointer));// repeated character has to be at leftPointer so we increment until the pointer isn't in the set
                leftPointer++;
            }
            seen.add(s.charAt(i));
            result = Math.max(result,(i - leftPointer) +1);// store the max between the result and the difference in indexes
        }
        return result;
    }
}
