    class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        int[] result = new int[nums.length];
        pre[0] = 1;
        post[post.length-1] = 1;
        for(int i= 1;i < pre.length;i++){
            pre[i] = nums[i-1] * pre[i-1];
        }
        for(int i= post.length -2;i > -1;i--){
            post[i] = nums[i+1] * post[i+1];
        }
        for(int i = 0;i < nums.length;i++){
            result[i] = pre[i] * post[i];
        }
        return result;
    }
} 
/*
 result at any given index in nums would be the product of the previous index in the pre-fix array
 and following index in the post-fix array 
  
input =[1,2,4,6]
pre = [0,1,2,8]
post = [48,24,6,0]
output = [48,24,12,8]












*/