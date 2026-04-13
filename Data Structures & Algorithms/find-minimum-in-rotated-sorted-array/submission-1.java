class Solution {
    public int findMin(int[] nums) {
        // minimum rotation  = 1
        // maximum rotation = n where n is the number of elements in nums
        // could brute force by finding minimum value
        // are all elements  consecutive?
        // they seem to be all in consecutive order from greatest to least
        // look for lowest value 
        // maybe keep track of index of max and min so far???
        //we can find the min/ max by checking if the preceding and succeeding values are both greater/less than 
        // make some sort of check for left and right pointer relative to mid pointer, mid should find smallest
        //lower and upper bound are along the same sequence of numbers, the lower bound should be the minimum if not the current result
        int lowerBound = 0;
        int upperBound = nums.length -1;
        int result = nums[0];
        
        while (lowerBound <= upperBound){
            if (nums[lowerBound] <= nums[upperBound]){//if this sequence is ordered then the min has to be either the lowerBound or the current result
                result = Math.min(result,nums[lowerBound]);
                break;//we exit the loop as per the above comment
            } 
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            result = Math.min(result,nums[mid]);
            if (nums[lowerBound] <= nums[mid]){// this sequence would contain
                lowerBound = mid +1;    
            } else{
                upperBound = mid -1;
            }
        }

        return result;
    }
}
//adjust result 
// we need a comparison between the numbers for the result
//     3 4 5 6 1 2     #1
//     L   M     H     R=3
//           L M H     R=1
//     
//     
//     4 5 0 1 2 3    #2
//     L   M     H
//         L M    H
//         L H
//
//     4 5 6 7        #3
//     L M   H
//          
//
//
//