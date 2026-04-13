class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0,target,nums,res,comb);
        return res;
    }
    private void dfs(int i,int rem,int[] nums,List<List<Integer>> res,List<Integer> comb){
        if(rem == 0){
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int j = i; j < nums.length;j++){
            if (rem - nums[j] < 0){
                return;
            }
            comb.add(nums[j]);
            dfs(j,rem - nums[j],nums,res,comb);
            comb.remove(comb.size() -1);
        }
    }
}
