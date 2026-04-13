class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stack = new StringBuilder();

        backTrack(0,0,n,stack,result);
        return result;
    }
    private void backTrack(int openBrackets,int closedBrackets,int n,StringBuilder stack,List<String> result){
        if (openBrackets == closedBrackets && openBrackets == n){
            result.add(stack.toString());
            return;
        }
        if (openBrackets < n){
            stack.append('(');
            backTrack(openBrackets +1,closedBrackets,n,stack,result);
            stack.deleteCharAt(stack.length() -1);   
        }
        if (closedBrackets < openBrackets){
            stack.append(')');
            backTrack(openBrackets,closedBrackets+1,n,stack,result);
            stack.deleteCharAt(stack.length() -1);   
        }
    }
}
