class Solution {
    public int evalRPN(String[] tokens) {
        //Stack for numbers, push numbers to stack, pop top of stack twice for each operator encountered, calculate then push back to stack
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int index = 0; index < tokens.length;index++){
            if (Character.isDigit(tokens[index].charAt(tokens[index].length() - 1))){
                stack.push(Integer.parseInt(tokens[index]));
            } else {
                char op = tokens[index].charAt(0);
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result;
                if (op == '+'){
                    result = num1 + num2;
                } else if (op == '-'){
                    result = num1 - num2;
                }else if (op == '/'){
                    result = num1 / num2;
                }else {
                    result = num1 * num2;
                }
                System.out.println(num1 + " " + op + " " + num2 + " = " + result);
                stack.push(result);
            }
            System.out.println(stack);
        }
        return stack.pop();

        
    }
}
