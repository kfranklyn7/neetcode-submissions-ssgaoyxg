class Solution {
    public boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length;i++){
            for(int n = 0; n < nums.length -1;n++){
                if (n == i){
                    continue;
                }
                if(nums[i] == nums[n]){
                    return true;
                }
            }
        }


        return false;
    }
}
