class Solution {
    List<List<String>> result;
    List<String> part = new ArrayList<>();
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        dfs(s,0,0);
        return result;
    }
    private void dfs(String s,int j,int i){
        if (i >= s.length()){
            if(i == j){
            result.add(new ArrayList<>(part));
            }
            return;
        }
        if (isPali(s,j,i)){
            part.add(s.substring(j,i+1));
            dfs(s,i + 1, i+1);
            part.remove(part.size()-1);
        }
        dfs(s,j,i +1);
        
        
    }
    private boolean isPali(String s,int left,int right){
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// check if the string is a palindrome
// all individual characters of a string are palindromes
// we can probably use sliding window to represent each substring
