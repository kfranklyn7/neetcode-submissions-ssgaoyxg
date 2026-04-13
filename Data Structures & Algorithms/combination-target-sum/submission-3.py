class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        comb = []
        nums.sort()
        def dfs(i,rem):
            if (rem == 0):
                res.append(comb[:])
                return
            for j in range(i,len(nums)):
                if rem - nums[j] < 0:
                    return
                comb.append(nums[j])
                dfs(j,rem - nums[j])
                comb.pop(len(comb) -1)
        dfs(0,target)
        return res