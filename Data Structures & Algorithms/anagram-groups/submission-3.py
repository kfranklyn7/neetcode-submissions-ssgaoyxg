class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = []
        groups = {}
        for s in strs:
            key = tuple(sorted(s))#lists are mutable which means they aren't hashable so turn it into a tuple
            if key not in groups:
                groups[key]= []
            groups.get(key).append(s)
        for k,v in groups.items():
            result.append(v)
        return result