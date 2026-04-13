class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length;i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars,((a,b) -> a[0] - b[0]  ));
        for (int i = cars.length -1; i >-1;i--){
            double time = (double)(target- cars[i][0])/ cars[i][1];
            stack.push(time);
            if(stack.size() >=2 && stack.peek() <= stack.get(stack.size()-2)  ){
                stack.pop();
                
            }
            
            
        }
        return stack.size();
    }
}
// we can sort the arrays by their position then iterate through it in reverse order
// the position closest to the target would be the one furthest ahead
// we can push each car onto the stack and increment whenever the current car's arrival time is < the previous car's arrival time
// we otherwise do not increemnt the count
// either way we push onto the stack to maintain the positon of the last car
// s = d/t s*t = d t = d/s
//
//
//
 