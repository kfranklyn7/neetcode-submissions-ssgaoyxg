class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        complements = {}
        for idx,x in enumerate(nums):
            complement = target - x
            if complement in complements:
                return [complements[complement],idx]
            else:
                complements[x] = idx
        