class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        import heapq
        frequency = {}
        for num in nums:
            frequency[num] = frequency.get(num,0) + 1
        frequency_list = [(v,k) for k,v in frequency.items()]
        print(frequency_list)
        heapq.heapify_max(frequency_list)
        print(frequency_list)
        result = []
        for i in range(k):
            item = heapq.heappop_max(frequency_list)
            result.append(item[1])
        return result