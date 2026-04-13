class Solution {
    public int characterReplacement(String s, int k) {
        //only uppercase english letters
        // integer k represented characters we can choose to replace
        // perform k replacements and return the longest substring containing only one character
        HashMap<Character,Integer> count = new HashMap<>();
        int result = 0;
        

        int leftPointer = 0;
        int maxFrequency = 0;

        for(int rightPointer = 0; rightPointer < s.length();rightPointer++){
            count.put(s.charAt(rightPointer),count.getOrDefault(s.charAt(rightPointer),0) +1);// we increment or add the frequency of the character to the map
            maxFrequency = Math.max(maxFrequency, count.get(s.charAt(rightPointer))); // calculate the max between our current frequency and the max frequency 

            while ((rightPointer - leftPointer + 1) - maxFrequency > k){//as long as we can't replace anymore, we slide our pointer to the left
                count.put(s.charAt(leftPointer),count.get(s.charAt(leftPointer)) -1 );
                leftPointer++;
            }
            result = Math.max(result,rightPointer - leftPointer + 1);
        }
        return result;
    }
}
