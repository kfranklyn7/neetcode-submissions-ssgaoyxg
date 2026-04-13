class Solution {
    public int trap(int[] height) {
        if (height == null || height.length== 1){
            return 0;
        }
        int leftPointer = 0, rightPointer = height.length-1;
        int trapped = 0;
        int leftMax = height[leftPointer], rightMax = height[rightPointer];

        while (leftPointer < rightPointer){
            if (leftMax < rightMax){
                leftPointer++;
                leftMax = Math.max(height[leftPointer],leftMax);
                trapped += leftMax-height[leftPointer];
            }
            else{
                rightPointer--;
                rightMax = Math.max(height[rightPointer],rightMax);
                trapped += rightMax - height[rightPointer];
            }
        }
        return trapped;
    }
}
// 
//
//
//