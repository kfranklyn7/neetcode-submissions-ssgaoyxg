class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        comb = []
        candidates.sort()
        def dfs(i,rem):
            if rem == 0:
                res.append(comb[:])
                return
            if i>= len(candidates) or rem - candidates[i] < 0:
                return
            comb.append(candidates[i])
            dfs(i+1,rem-candidates[i])
            while(i+1 < len(candidates) and  candidates[i] == candidates[i+1]):
                i+=1
            comb.pop()
            dfs(i+1,rem)
        dfs(0,target)
        return res