class Solution {
    List<String> result;
    HashMap<Character,String> digitChar= new HashMap<>(Map.of('0',"",'1',"",'2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz"));

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.isEmpty()){
            return result;
        }
        dfs(digits,0,"");
        return result;
    }
    private void dfs(String digits,int i ,String currentString){
        if (currentString.length() == digits.length()){
            result.add(currentString);
            return;
        }
        for (char c : digitChar.get(digits.charAt(i)).toCharArray()){
            dfs(digits,i+1,currentString + c);
        }

    }
}
