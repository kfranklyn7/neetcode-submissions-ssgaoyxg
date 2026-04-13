class Solution {
    public boolean isValid(String s) {
        Deque<Character> matching = new ArrayDeque<>();//stack stores brackets, pops them when their closing bracket is matched
        Map<Character,Character> brack = new HashMap<>();// holds the opening bracket as a key in order to pop from stack

        brack.put('}','{');
        brack.put(')','(');
        brack.put(']','[');
        
        for (char c : s.toCharArray()){
            if (c == '{' || c == '[' || c == '('){
                matching.push(c);
            } else {
                if (brack.get(c) == matching.peek()){
                    matching.pop();
                } else {
                    return false;
                }
            }
        }
         return matching.isEmpty();//returns true if the stack is empty as all brackets are matched
    }


   
}
