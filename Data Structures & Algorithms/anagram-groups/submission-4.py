class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = {}
        for s in strs:
            chars = tuple(sorted(s))
            if chars not in anagrams:
                anagrams[chars] = []
            anagrams[chars].append(s)
        return list(anagrams.values())
            
            