class Solution {
    List<List<Integer>> result ;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>(),0,target);
        return result;
    }
    private void dfs(int[] nums,int i,List<Integer> subset,int total,int target){
      if (total == target){
            result.add(new ArrayList<>(subset));
            return;
      }
      for (int j = i; j <nums.length; j++){
            if (total + nums[j] > target){
                return;
            }
            subset.add(nums[j]);
            dfs(nums,j,subset,total + nums[j],target);
            subset.remove(subset.size()-1);
      }
    }
}
