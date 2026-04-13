class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
        for (int index =0; index < nums.length; index++){
            if(nums[index] >0) break;//no negative numbers left
            if(index > 0 && nums[index] == nums[index -1]) continue;
            int leftPointer = index +1;
            int rightPointer = nums.length-1;
            while (leftPointer < rightPointer){
                int sum = nums[index] + nums[leftPointer] + nums[rightPointer];
                if (sum > 0){
                    rightPointer--;
                } else if (sum < 0) {
                    leftPointer++;
                } else {
                    result.add(Arrays.asList(nums[index],nums[leftPointer],nums[rightPointer]));
                    leftPointer++;
                    rightPointer--;
                    while (nums[leftPointer] == nums[leftPointer -1] && leftPointer < rightPointer){
                        leftPointer++;
                    }
                }
        }

    }
    
    return result;
    }
}
// a + b + c = 0
// a + b = -c
// c = -(a+b)
//
//a
//
//
// in order to reach zero, generally one of the numbers has to be negative
// if a number is negative, in a sorted array, we find it to the left of the array
// since the array is sorted we use a similar solution to two sum 2
//  we can then simply look for a combination of b and c that equal to -a
//
//
//