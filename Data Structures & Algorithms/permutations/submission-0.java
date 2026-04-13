class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        dfs(nums,new ArrayList<>(),new boolean[nums.length]);
        return result;
    }
    private void dfs(int[] nums,List<Integer> permutation,boolean[] pick){
        if (permutation.size() == nums.length){
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int index =0; index < nums.length; index++){
            if(!pick[index]){
                permutation.add(nums[index]);
                pick[index] = true;
                dfs(nums,permutation,pick);
                permutation.remove(permutation.size() -1);
                pick[index] = false;
            }

        }
    }
}
/*
Intuition: similar to subsets 2 or combination sum where we need to sort
we don't include the empty set
we add numbers until the permutation is the length of numbers
we go down each branch for each individual number where a number is picked or not picked
*/
