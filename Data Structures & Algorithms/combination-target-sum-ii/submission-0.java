class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);//we sort to make it easier to avoid "bad" combinations
        dfs(candidates,target,0,0,new ArrayList<>());
        return result;
        
    }
    private void dfs(int[] candidates, int target,int i, int total,List<Integer> combination){
        if (target == total){
            result.add(new ArrayList<>(combination));
            return;
        }
        if( i >= candidates.length || total > target ){
            return;
        }
        combination.add(candidates[i]);
        dfs(candidates,target,i+1,total + candidates[i],combination);
        while(i+1 < candidates.length && candidates[i] == candidates[i+1] ){
            i++;
        }
        combination.remove(combination.size() -1);
        dfs(candidates,target,i+1,total,combination);
        
    }
}
