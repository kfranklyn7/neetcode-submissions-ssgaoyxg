class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        int[] letters = new int[26];
        int[] letters2 = new int[26];
        for (int i = 0; i< s1.length();i++){
            letters[s1.charAt(i) - 'a']++;
            letters2[s2.charAt(i) - 'a']++;
        }
        int matches = 0; // represents how many counts of letters match between the string we want to find and our current window

        //make a sliding window the size of s1 and "slide it" over s2
        for (int i  = 0; i < 26; i++){
            if (letters[i] == letters2[i]){
                matches++;
            }
        }// intializes the matching letters

        int leftPointer = 0;
        for (int rightPointer = s1.length();rightPointer < s2.length(); rightPointer++){
            if (matches == 26){
                return true;
            }
            
            int index = s2.charAt(rightPointer) - 'a';
            letters2[index]++;
            if(letters[index] == letters2[index]){
                matches++;
            } else if (letters[index] + 1 == letters2[index]){
                matches--;
            }
            
            index = s2.charAt(leftPointer) - 'a';
            letters2[index]--;
            if(letters[index] == letters2[index]){
                matches++;
            } else if (letters[index] - 1 == letters2[index]){
                matches--;
            }
            leftPointer++;

        }
        return matches == 26;
    }
}
