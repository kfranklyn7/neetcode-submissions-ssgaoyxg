class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        pre[0] = 1;
        post[nums.length-1] = 1;
        for (int i = 1; i< nums.length;i++){
            pre[i] = pre[i-1] * nums[i-1];
        }
        for (int i = nums.length-2 ; i > -1 ; i--){
            post[i] = post[i+1] * nums[i+1];
        }
        for (int i =0;i< nums.length; i++){
            res[i] = pre[i] * post[i];
        }
        return res;
    }
} 
//  nums = [1,2,4,6]
// [48,24,12,8]
// pre   [1,1,2,8]
// post   [1,6,24,48]
// res []
//
