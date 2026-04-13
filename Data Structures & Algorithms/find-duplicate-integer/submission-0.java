class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast){
                break;
            }
        }// we find the point at which both pointers intersect for loop detection
        
        int slow2 = 0; // we make a second slow pointer to increment both until they intersect
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2){
                return slow; // we return the index at which the pointers intersect
            }
        }
        
    }
}
