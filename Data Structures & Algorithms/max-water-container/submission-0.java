class Solution {
    public int maxArea(int[] height) {
        int leftPointer = 0,  rightPointer = height.length -1;
        int minHeight = 1;
        int result = 0;
        while (leftPointer < rightPointer){
            // we want to prioritize higher heights so we move the pointer
            //int width = rightPointer - leftPointer;
            int area = (rightPointer-leftPointer) * Math.min(height[leftPointer],height[rightPointer]);
            if(height[leftPointer]>height[rightPointer]){
              rightPointer--;  
            } else {
                leftPointer++;
            }
            result = Math.max(area,result);
        
        }
        return result;

    }
}
// we can treat the index as the X axis
// naturally the height[index] is the y axis
// so the X value is the difference between the two indexes
// the Y value is the minimum between the two heights
// do we pre-compute or compute at each step?
// we can be greedy and maximize the heights
// what happens if we change the height
// do we have to calculate the difference between the indexes before hand??
//  0 1 2 3 4 5 6 7 8    
// [1,8,6,2,5,4,8,3,7]
//  ^                ^  
//  L                R
//    L
//
//
