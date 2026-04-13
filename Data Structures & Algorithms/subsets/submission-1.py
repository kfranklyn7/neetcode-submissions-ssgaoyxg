class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        choice = []
        def dfs(i : int, res : List,choice : List):
            
            if (i >= len(nums)):
                res.append(choice[:])
                return
            choice.append(nums[i])
            dfs(i+1,res,choice)
            choice.pop(len(choice)-1)
            dfs(i+1,res,choice)
            return
        dfs(0,res,choice)
        return res
        
        

