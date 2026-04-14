class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0,target,candidates,comb,res);
        return res;
    }

    private void dfs(int i,int rem,int[] cand,List<Integer> comb,List<List<Integer>> res){
            if(rem == 0){
                res.add(new ArrayList<>(comb));
                return;
            }    
            if( i >=cand.length || rem - cand[i] < 0 ){
                return;
            }
            comb.add(cand[i]);
            dfs(i+1,rem-cand[i],cand,comb,res);
            while(i+1 < cand.length && cand[i] == cand[i+1]){
                i++;
            }
            comb.remove(comb.size()-1);
            dfs(i+1,rem,cand,comb,res);
    }
}
