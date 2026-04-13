class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>());
        return result;
    }
    private void dfs(int[] nums,int index,List<Integer> subset){
        if (index >= nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(nums,index + 1,subset);
        while (index + 1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }
        subset.remove(subset.size() -1);
        dfs(nums,index + 1,subset);
    }
}
