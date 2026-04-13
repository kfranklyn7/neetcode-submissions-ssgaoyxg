class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] result = new int[temperatures.length];
        stack.push(temperatures.length -1);
        result[result.length-1] = 0;
         for(int index = temperatures.length -2; index > -1; index--){
                if (stack.isEmpty()){
                    result[index] = 0;
                }else {
                    while (!stack.isEmpty()){
                        if (temperatures[stack.peek()] > temperatures[index]){
                            result[index] = stack.peek()- index;
                            break;
                        }
                        stack.pop();
                    }
                }               
                stack.push(index);
 
        }
        return result;
    }
}
//  We can use a stack and traverse the array in the reverse order
//  [30,38,30,36,35,40,28]
//   [0] empty so we add it
//   [0,0] 28 less than 40 we pop the index of 28 and push 40
//   [1,0,0] we subtract the two indexes since 40 > 35
//   [2,1,0,0] we 
//
//
//
//
//  [1,4,1,2,1,0,0]
