class Solution {
    public boolean isAnagram(String s, String t) {
       if (s.length() != t.length()){
            return false;
        }
        if (s.length() == 0 && t.length() == 0){
            return true;
        }
        Map<Character,Integer> freq = new HashMap<>();
        Map<Character,Integer> freq2 = new HashMap<>();
        for (int index = 0; index < s.length(); index++){
            char curr = s.charAt(index);
            char curr2 = t.charAt(index);
            freq.put(curr,freq.getOrDefault(curr,1)+1);
            freq2.put(curr2,freq2.getOrDefault(curr2,1)+1);
        }
        if (freq.equals(freq2)){
            return true;
        } else {
            return false;
        }

        
    }
}
        
/*
"Gojo" "Jogo" "Ogoj" "oogj" "jgoo"

*/