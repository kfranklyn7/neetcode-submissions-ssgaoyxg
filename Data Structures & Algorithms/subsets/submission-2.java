class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> choice = new ArrayList<>();
        dfs(0,nums,res,choice);
        return res;
    }
    private void dfs(int i,int[] nums, List<List<Integer>> res,List<Integer> choice){
        if(i >= nums.length){
            res.add(new ArrayList<>(choice));
            return;
        }
        choice.add(nums[i]);
        dfs(i+1,nums,res,choice);
        choice.remove(choice.size()-1);
        dfs(i+1,nums,res,choice);
        return;
    }
}
