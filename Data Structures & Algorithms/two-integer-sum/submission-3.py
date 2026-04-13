class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        complements = {}
        for index,n in enumerate(nums):
            complement = target - n
            if complement in complements:
                return [complements[complement], index]
            complements[n] = index