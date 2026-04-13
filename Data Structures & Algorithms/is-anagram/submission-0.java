class Solution {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()){
            return false;
        }
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        char[] letters2 = t.toCharArray();
        Arrays.sort(letters2);
        if (Arrays.equals(letters,letters2) ) {
            return true;
        }
        return false;
        
    }
}
